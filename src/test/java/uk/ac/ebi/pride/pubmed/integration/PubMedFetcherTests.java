package uk.ac.ebi.pride.pubmed.integration;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import uk.ac.ebi.pride.pubmed.PubMedFetcher;
import uk.ac.ebi.pride.pubmed.model.ReferenceSummary;
import java.io.IOException;

public class PubMedFetcherTests {
  private static Logger log = LoggerFactory.getLogger(PubMedFetcherTests.class);

  @Test
  public void testService() throws Exception {
    assertSummaryReference(PubMedFetcher.getPubMedSummary("22147733"));
    assertSummaryReference(PubMedFetcher.getPubMedSummary("22807455"));
    assertSummaryReference(PubMedFetcher.getPubMedSummary("22825847"));
    assertSummaryReference(PubMedFetcher.getPubMedSummary("24607996"));
  }

  private void assertSummaryReference(ReferenceSummary summary) throws IOException {
    Assert.isTrue(summary!=null, "Summary cannot be null");
    Assert.isTrue(summary.getRefLine()!=null, "Summary RefLine cannot be null");
    Assert.isTrue(summary.getEupmcResult()!=null, "Summary Result cannot be null");
    log.info("Summary reference: " + summary.getRefLine());
  }
}
