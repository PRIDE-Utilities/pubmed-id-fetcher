package uk.ac.ebi.pride.pubmed.util;

/**
 * @author Jose A. Dianes
 * @version $Id$
 */
public enum PubMedRegEx {
    EPUB_REGEX("Epub\\s+\\d+\\s+\\w+\\s+\\d+[;\\.]?"),
    PMID_REGEX("PubMed\\s+PMID:\\s+\\d+[;\\.]?"),
    PMCID_REGEX("PubMed\\s+Central\\s+PMCID:\\s+PMC\\d+[;\\.]?"),
    // doi: 10.1002/pmic.201200003
    //todo add all possibl doi regexe
    DOI_REGEX("doi:\\s+\\S+\\s"),
    INDEX_NUMBER_REGEX("\\d+:\\s+"),
    EPUB_AOP_REGEX("\\s*\\[Epub\\s+ahead\\s+of\\s+print\\]\\s*")
    ;
    private String regEx;

    private PubMedRegEx(String regEx) {
        this.regEx = regEx;
    }

    public String getRegEx() {
        return regEx;
    }
}
