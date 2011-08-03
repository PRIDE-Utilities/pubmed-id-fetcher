/**
 * Created by IntelliJ IDEA.
 * User: attilacsordas
 * Date: May 3, 2011
 * Time: 3:25:17 PM
 * To change this template use File | Settings | File Templates.
 */

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;


public class PubMedUtils {

    public static Logger logger = Logger.getLogger(PubMedUtils.class.getName());
    public static final String PUBMED_EUTILS = "http://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi";

    public static String getPubMedSummary(String pubmedId) throws IOException {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("db", "pubmed");
        parameters.put("id", pubmedId);
        parameters.put("report", "docsum");
        parameters.put("mode", "text");

        // call makeGetRequest on base url + parameters
        InputStream response = makeGetRequest(PUBMED_EUTILS, parameters);

        // read from input stream
        BufferedReader reader = new BufferedReader(new InputStreamReader(response));
        StringBuilder summary = new StringBuilder();
        String line = null;

        while ((line = reader.readLine()) != null) {
            summary.append(line);
        }

        return summary.toString();
    }

    @SuppressWarnings("unchecked")
    private static InputStream makeGetRequest(String baseURL,
                                              Map<String, String> parameters) {
        HttpClient httpClient = new HttpClient();

        GetMethod get = new GetMethod(baseURL);
        NameValuePair[] httpParameters = new NameValuePair[parameters.size()];
        int i = 0;
        for (Entry<String, String> e : parameters.entrySet()) {
            NameValuePair pair = new NameValuePair(e.getKey(), e.getValue());
            httpParameters[i] = pair;
            i++;
        }
        get.setQueryString(httpParameters);

        try {
            int statusCode = httpClient.executeMethod(get);
            if (statusCode != HttpStatus.SC_OK) {
                logger.warning("request failed. parameters: " + parameters);
            } else {
                InputStream responseStream = get.getResponseBodyAsStream();
                return responseStream;
            }
        } catch (HttpException e) {
            logger.warning("protocol violation: " + e.getMessage());
        } catch (IOException e) {
            logger.warning("transport error: " + e.getMessage());
        }
        get.releaseConnection();
        return null;
    }

    public static void main(String[] args) {

        try {
            System.out.println(getPubMedSummary("15852344"));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

}


