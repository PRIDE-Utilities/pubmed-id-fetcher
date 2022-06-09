package uk.ac.ebi.pride.pubmed;

import lombok.Builder;
import lombok.Data;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class helps to retrieve the information from Pubmed including id, title, etc.
 * @author ypriverol
 */
public class ReferenceUtil {



    public static PubMedReference getPubmedReference(String pubmedId) throws Exception {
        final int rateLimit = 50;
        int k = 0;
        while(k < rateLimit){
            try {
                //try and connect to ncbi
                String ncbiUrl = "https://eutils.ncbi.nlm.nih.gov/entrez/eutils/esummary.fcgi?db=pubmed&id=" + pubmedId;
                URL url = new URL(ncbiUrl);
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(url.openStream());
                doc.getDocumentElement().normalize();
                NodeList nList = doc.getElementsByTagName("DocSum");

                if (nList.getLength() == 1) {

                    PubMedReference ref = new PubMedReference();

                    NodeList items = doc.getElementsByTagName("Item");
                    for (int i = 0; i < items.getLength(); i++) {

                        Node node = items.item(i);
                        String nodeName = node.getAttributes().getNamedItem("Name").getFirstChild().getNodeValue();
                        if (nodeName.equals("PubDate")) {
                            ref.setDate(getValue(node));
                        }
                        if (nodeName.equals("Source")) {
                            ref.setSource(getValue(node));
                        }
                        if (nodeName.equals("Author")) {
                            ref.addAuthor(getValue(node));
                        }
                        if (nodeName.equals("Title")) {
                            ref.setTitle(getValue(node));
                        }
                        if (nodeName.equals("Volume")) {
                            ref.setVolume(getValue(node));
                        }
                        if (nodeName.equals("Issue")) {
                            ref.setIssue(getValue(node));
                        }
                        if (nodeName.equals("Pages")) {
                            ref.setPages(getValue(node));
                        }
                        if (nodeName.equals("doi")) {
                            ref.setDoi(getValue(node));
                        }
                        if(nodeName.equals("pmc")){
                            ref.setPmcid(getValue(node));
                        }
                        if(nodeName.equals("PubType")){
                            ref.setPubType(getValue(node));
                        }
                        if (nodeName.equals("pubmed")) {
                            String nodeType = node.getAttributes().getNamedItem("Type").getFirstChild().getNodeValue();
                            if(Objects.equals(nodeType, "String") && isNumeric(getValue(node)))
                                ref.setPmid(getValue(node));
                        }
                    }
                    return ref;
                }
            } catch (Exception e) {
                k++;
                Thread.sleep(k * 1000);
            }
        }
        throw new IllegalStateException("Error retrieving pubmed citation for " + pubmedId);
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private static String getValue(Node node) {
        //<Item Name="PubDate" Type="Date">2006 Feb 28</Item>
        if (node.getFirstChild() != null) {
            return node.getFirstChild().getNodeValue();
        } else {
            return node.getNodeValue();
        }

    }

    @Data
    public static class PubMedReference {

        private String date;
        private String title;
        private String pmid;
        private List<String> authors = new ArrayList<>();
        private String source;
        private String volume;
        private String issue;
        private String pages;
        private String doi;
        private String pmcid;
        private String pubType;

        public PubMedReference() {}

        public void addAuthor(String author) {
            authors.add(author);
        }

        @Override
        public String toString() {
            String sb = "PubMedReference" +
                    "{date='" + date + '\'' +
                    ", title='" + title + '\'' +
                    ", pmid='" + pmid + '\'' +
                    ", authors=" + authors +
                    ", source='" + source + '\'' +
                    ", volume='" + volume + '\'' +
                    ", issue='" + issue + '\'' +
                    ", pages='" + pages + '\'' +
                    ", doi='" + doi + '\'' +
                    '}';
            return sb;
        }

        /**
         * Returns the list of authors as an String sentence.
         * @return
         */
        public String getAuthorString() {
            return String.join(",", authors);
        }
    }
}
