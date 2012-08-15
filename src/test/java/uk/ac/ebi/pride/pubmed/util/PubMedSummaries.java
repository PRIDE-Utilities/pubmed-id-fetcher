package uk.ac.ebi.pride.pubmed.util;

/**
 * @author Jose A. Dianes
 * @version $Id$
 */
public enum PubMedSummaries {
    SUMMARY_22807455("22807455","1: Goswami T, Li X, Smith AM, Luderowski EM, Vincent JJ, Rush J, Ballif BA.\n" +
            "Comparative phosphoproteomic analysis of neonatal and adult murine brain.\n" +
            "Proteomics. 2012 Jul;12(13):2185-9. doi: 10.1002/pmic.201200003. PubMed PMID:\n" +
            "22807455."),
    SUMMARY_22147733("22147733","1: Thomas L, Hodgson DA, Wentzel A, Nieselt K, Ellingsen TE, Moore J, Morrissey\n" +
            "ER, Legaie R; STREAM Consortium, Wohlleben W, Rodríguez-García A, Martín JF,\n" +
            "Burroughs NJ, Wellington EM, Smith MC. Metabolic switches and adaptations deduced\n" +
            "from the proteomes of Streptomyces coelicolor wild type and phoP mutant grown in \n" +
            "batch culture. Mol Cell Proteomics. 2012 Feb;11(2):M111.013797. Epub 2011 Dec 6. \n" +
            "PubMed PMID: 22147733; PubMed Central PMCID: PMC3277767."),
    SUMMARY_22825847("22825847", "1: Wejda M, Impens F, Takahashi N, Van Damme P, Gevaert K, Vandenabeele P.\n" +
            "Degradomics reveals that cleavage specificity profiles of caspase-2 and effector \n" +
            "caspases are alike. J Biol Chem. 2012 Jul 23. [Epub ahead of print] PubMed PMID: \n" +
            "22825847.")

    ;

    private String id;
    private String summary;

    private PubMedSummaries(String id, String summary) {
        this.id = id;
        this.summary = summary;
    }

    public String getId() {
        return id;
    }

    public String getSummary() {
        return summary;
    }
}
