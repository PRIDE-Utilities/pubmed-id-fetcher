package uk.ac.ebi.pride.pubmed.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Models the 'tmAccessionTypeList' field from a EU PMC result.
 */
@Getter
@Setter
public class EupmcTmAccessionTypeArray {
  String[] accessionType;
}
