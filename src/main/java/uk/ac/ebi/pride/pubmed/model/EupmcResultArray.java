package uk.ac.ebi.pride.pubmed.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * Models the 'resultList' from a EU PMC response.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EupmcResultArray {
  EupmcResult[] result;
}