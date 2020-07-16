package uk.ac.ebi.pride.pubmed.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * Models a response from the EU PMC.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EupmcResponse {
  private String version;
  private int hitCount;
  private String nextCursorMark;
  private EupmcRequest request;
  private EupmcResultArray resultList;
}
