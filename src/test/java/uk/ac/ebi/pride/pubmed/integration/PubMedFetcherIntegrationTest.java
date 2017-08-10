/*package uk.ac.ebi.pride.pubmed.integration;

import org.eclipse.jetty.server.Server;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.ac.ebi.pride.pubmed.PubMedFetcher;
import uk.ac.ebi.pride.pubmed.mockups.PubMedEutilsRequestHandler;
import uk.ac.ebi.pride.pubmed.util.PubMedSummaries;

import java.util.logging.Logger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Jose A. Dianes
 * @version $Id$



    public static final String PUBMED_ID = "22147733";
    public static final String PUBMED_CID = "PMC3277767";
    public static final String EPUB = "Epub 2011 Dec 6";

    public static final int TEST_EUTILS_PORT = 4321;

    private static Server server;

    private static Thread serverThread;

    @Autowired
    private PubMedFetcher pubMedFetcher;


    @BeforeClass
    public static void setUp() throws Exception {
        server = new Server(TEST_EUTILS_PORT);
        // set the dummy handler and start the server
        server.setHandler(new PubMedEutilsRequestHandler());
        server.start();
        // we need to use a separate thread here because the join() operation is a blocking one
        serverThread = new Thread(new Runnable() {
            public void run() {
                logger.info("Starting Jetty server at port " + TEST_EUTILS_PORT);
                try {
                    server.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
                logger.info("Stopping Jetty server at port "+TEST_EUTILS_PORT);
            }
        });
        // finally start the thread
        serverThread.start();


    }

    @Test
    public void testGetPubmedSummaryText() throws Exception {
        String pubMedSummaryText = pubMedFetcher.getPubMedSummaryText(PubMedSummaries.SUMMARY_22147733.getId());

        assertThat(pubMedSummaryText==null, is(false));
        assertThat(PubMedSummaries.SUMMARY_22147733.getSummary().replaceAll("\n", "").equals(pubMedSummaryText.replaceAll("\n", "")), is(true));

    }

    @Test
    public void testGetPubmedSummary() throws Exception {
        PubMedSummary pubmedSummary = pubMedFetcher.getPubMedSummary(PubMedSummaries.SUMMARY_22147733.getId());

        assertThat(pubmedSummary==null, is(false));
        assertThat(PUBMED_ID.equals(pubmedSummary.getPmid()), is(true));
        assertThat(PUBMED_CID.equals(pubmedSummary.getPmcid()), is(true));
        assertThat(EPUB.equals(pubmedSummary.getEpub()), is(true));

    }

    @AfterClass
    public static void tearDown() throws Exception {
        server.stop(); // this should stop the thread as well
    }


}
*/