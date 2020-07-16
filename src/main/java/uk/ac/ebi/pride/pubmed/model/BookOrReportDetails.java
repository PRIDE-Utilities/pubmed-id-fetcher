package uk.ac.ebi.pride.pubmed.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Suresh Hewapathirana
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookOrReportDetails {
   private String publisher;
   private String yearOfPublication;
}
