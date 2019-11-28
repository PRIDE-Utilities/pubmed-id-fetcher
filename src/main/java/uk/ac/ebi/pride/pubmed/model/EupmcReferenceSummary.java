package uk.ac.ebi.pride.pubmed.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Holds a reference line ('refLine') summary, and a EU PMC reference result.
 */
@Getter
@Setter
public class EupmcReferenceSummary {
    private String refLine;
    private EupmcResult eupmcResult;
}
