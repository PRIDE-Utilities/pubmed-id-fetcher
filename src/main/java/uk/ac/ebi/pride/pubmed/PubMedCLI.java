package uk.ac.ebi.pride.pubmed;

import java.io.IOException;

/**
 * @author Jose A. Dianes
 * @version $Id$
 */
public class PubMedCLI {
    public static void main(String[] args) {
        PubMedFetcher pubMedFetcher = new PubMedFetcher(null); // TODO: get args with Spring context
        try {
//            System.out.println(getPubMedSummary("22147733"));
            System.out.println(pubMedFetcher.getPubMedSummary(args[0]));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
