package uk.ac.ebi.pride.pubmed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;
import uk.ac.ebi.pride.pubmed.model.PubMedSummary;
import uk.ac.ebi.pride.pubmed.util.PubMedRegEx;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * NOTE: Sometimes the answer from the server may have a /n instead of a space. Therefore we substitute all /n by blank
 * spaces. However, this means that sometimes we may find double spaces and the REGEX will not match. Therefore we need
 * to replace all "  " (double spaces) by " " (single spaces).
 *
 * @author Jose A. Dianes
 * @author Attila Csordas
 * @version $Id$
 */
public class PubMedFetcher {

    public static Logger logger = Logger.getLogger(PubMedFetcher.class.getName());

    // example http://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi?db=pubmed&id=15852344&rettype=docsum&retmode=text
    private String pubmedEutilsUrl;

    @Autowired
    public PubMedFetcher(String pubmedEutilsUrl) {
        Assert.notNull(pubmedEutilsUrl, "Pubmed eUtils URL cannot be null");
        this.pubmedEutilsUrl = pubmedEutilsUrl;
    }

    public String getPubMedSummaryText(String pubmedId) throws IOException {
        // lazy instantiation of a RestTemplate to use the PubMed service
        RestTemplate restTemplate = new RestTemplate();

        // set the params
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("db", "pubmed");
        parameters.put("id", pubmedId);
        parameters.put("rettype", "docsum");
        parameters.put("retmode", "text");

        // build the url
        String url = pubmedEutilsUrl.replaceAll("/$", "")
                + "/efetch.fcgi?db={db}&id={id}&rettype={rettype}&retmode={retmode}";

        // invoke the service
        String response = (String) restTemplate.getForObject(url, String.class, parameters);

        return response;
    }

    public PubMedSummary getPubMedSummary(String pubmedId) throws IOException {
        return parseSummaryText(this.getPubMedSummaryText(pubmedId));
    }

    private PubMedSummary parseSummaryText(String summaryText) {
        PubMedSummary res = new PubMedSummary();

        summaryText = summaryText.replaceAll("\n", " ");

        // find elements, starting with PMID
        Pattern pattern = Pattern.compile(PubMedRegEx.PMID_REGEX.getRegEx());
        Matcher matcher = pattern.matcher(summaryText);
        if (matcher.find()) { // PMID found
            String [] elems = clean(summaryText.substring(matcher.start(), matcher.end())).split(" ");
            String pubmedId = clean(elems[2]);
            res.setPmid(pubmedId);
            summaryText = matcher.replaceAll("");
        }
        // find PMCID
        pattern = Pattern.compile(PubMedRegEx.PMCID_REGEX.getRegEx());
        matcher = pattern.matcher(summaryText);
        if (matcher.find()) { // PMCID found
            String [] elems = clean(summaryText.substring(matcher.start(), matcher.end())).split(" ");
            String pubmedCId = clean(elems[3]);
            res.setPmcid(pubmedCId);
            summaryText = matcher.replaceAll("");
        }
        // find EPUB
        pattern = Pattern.compile(PubMedRegEx.EPUB_REGEX.getRegEx());
        matcher = pattern.matcher(summaryText);
        if (matcher.find()) { // EPUB found
            String epub = clean(summaryText.substring(matcher.start(), matcher.end()));
            res.setEpub(epub);
            summaryText = matcher.replaceAll("");
        }
        // find DOI
        pattern = Pattern.compile(PubMedRegEx.DOI_REGEX.getRegEx());
        matcher = pattern.matcher(summaryText);
        if (matcher.find()) { // DOI found
            String [] elems = clean(summaryText.substring(matcher.start(), matcher.end())).split(" ");
            res.setDoi(clean(elems[1]));
            summaryText = matcher.replaceAll("");
        }
        // check and remove index number if present
        pattern = Pattern.compile(PubMedRegEx.INDEX_NUMBER_REGEX.getRegEx());
        matcher = pattern.matcher(summaryText);
        if (matcher.find()) { // INDEX_NUMBER found
            summaryText = matcher.replaceAll("");
        }
        // check for EPUB AOP
        pattern = Pattern.compile(PubMedRegEx.EPUB_AOP_REGEX.getRegEx());
        matcher = pattern.matcher(summaryText);
        if (matcher.find()) { // EPUB Ahead Of Print found
            res.setEpubAheadOfPrint(true);
            summaryText = matcher.replaceAll("");
        }

        // the remaining text is the reference itself
        res.setReference(clean(summaryText.trim()));

        return res;
    }

    public PubMedSummary parsePubmedSummaryText(String summaryText) {
        return this.parseSummaryText(summaryText);
    }


    private String clean(String text) {
        String res = text;
        // remove trailing spaces, . and ;
        while (res.endsWith(".") || res.endsWith(";") || res.endsWith(" "))
            res = res.substring(0,res.length()-1);
        // remove heading spaces, . and ;
        while (res.startsWith(".") || res.startsWith(";") || res.startsWith(" "))
            res = res.substring(1,res.length());
        // remove double spacing
        while (res.contains("  "))
            res = res.replace("  ", " ");
        return res;
    }



}


