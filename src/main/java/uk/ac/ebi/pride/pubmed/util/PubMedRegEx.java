package uk.ac.ebi.pride.pubmed.util;

/**
 * @author Jose A. Dianes
 * @version $Id$
 */
public enum PubMedRegEx {
    EPUB_REGEX("Epub \\d+ \\w+ \\d+;?.?"),
    PMID_REGEX("PubMed PMID: \\d+;?.?"),
    PMCID_REGEX("PubMed Central PMCID: PMC\\d+;?.?"),
    // doi: 10.1002/pmic.201200003
    DOI_REGEX("doi: \\S+\\s")
    ;
    private String regEx;

    private PubMedRegEx(String regEx) {
        this.regEx = regEx;
    }

    public String getRegEx() {
        return regEx;
    }
}
