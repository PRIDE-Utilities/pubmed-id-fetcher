package uk.ac.ebi.pride.pubmed.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * Models a 'dbCrossReferenceList' use in a EU PMC result.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EupmcDbCrossReferenceArray {
  String[] dbName;
}
