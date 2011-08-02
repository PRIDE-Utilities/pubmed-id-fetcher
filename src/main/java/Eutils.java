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


public class Eutils {

    public static Logger logger = Logger.getLogger(Eutils.class.getName());

    // http://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi?db=pubmed&id=15852344&report=docsum&mode=text


    public static String getPubMedSummary(String pubmedId) {
        String baseUrl = "http://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi";
        Map<String, String> parameters = new HashMap();


        parameters.put("db", "pubmed");
        parameters.put("id", pubmedId);
        parameters.put("report", "docsum");
        parameters.put("mode", "text");

        // call makeGetRequest on base url + parameters

        InputStream response = makeGetRequest(baseUrl, parameters);


        // read from input stream

        BufferedReader reader = new BufferedReader(new InputStreamReader(response));
        String line = null;

        try {
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
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

        getPubMedSummary("15852344");
    }

}


