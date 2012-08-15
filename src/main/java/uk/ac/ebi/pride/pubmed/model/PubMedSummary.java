package uk.ac.ebi.pride.pubmed.model;

/**
 * @author Jose A. Dianes
 * @version $Id$
 */
public class PubMedSummary {
    private String reference;
    private String pmid;
    private String pmcid;
    private String doi;
    private String epub;
    private boolean epubAheadOfPrint = false;


    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getPmid() {
        return pmid;
    }

    public void setPmid(String pmid) {
        this.pmid = pmid;
    }

    public String getPmcid() {
        return pmcid;
    }

    public void setPmcid(String pmcid) {
        this.pmcid = pmcid;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getEpub() {
        return epub;
    }

    public void setEpub(String epub) {
        this.epub = epub;
    }

    public boolean isEpubAheadOfPrint() {
        return epubAheadOfPrint;
    }

    public void setEpubAheadOfPrint(boolean epubAheadOfPrint) {
        this.epubAheadOfPrint = epubAheadOfPrint;
    }
}
