package uk.ac.ebi.pride.pubmed.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * Holds a reference line ('refLine') summary, and a EU PMC reference result.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EupmcReferenceSummary{
    private String refLine;
    private EupmcResult eupmcResult;
}
