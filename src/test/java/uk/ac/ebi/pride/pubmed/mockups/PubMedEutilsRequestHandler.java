package uk.ac.ebi.pride.pubmed.mockups;


import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import uk.ac.ebi.pride.pubmed.util.PubMedSummaries;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author Jose A. Dianes
 * @version $Id$
 */
public class PubMedEutilsRequestHandler extends AbstractHandler {

    public static Logger logger = Logger.getLogger(PubMedEutilsRequestHandler.class.getName());

    @Override
    public void handle(String s, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {

        logger.info("Request received: " + request.getOriginalURI());

        httpServletResponse.setContentType("text/html;charset=utf-8");
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        request.setHandled(true);
        // !use writer.print not writer.println, as the latter will add a new line which causes troubles in the test!
        httpServletResponse.getWriter().print(PubMedSummaries.SUMMARY_22147733.getSummary());
    }
}
