package uk.ac.ebi.pride.pubmed.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Models the 'resultList' from a EU PMC response.
 */
@Getter
@Setter
public class EupmcResultArray {
  EupmcResult[] result;
}