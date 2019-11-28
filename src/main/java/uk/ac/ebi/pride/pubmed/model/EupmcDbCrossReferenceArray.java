package uk.ac.ebi.pride.pubmed.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Models a 'dbCrossReferenceList' use in a EU PMC result.
 */
@Getter
@Setter
public class EupmcDbCrossReferenceArray {
  String[] dbName;
}
