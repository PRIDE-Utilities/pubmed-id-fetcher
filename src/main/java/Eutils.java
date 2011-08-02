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

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;
// import org.omg.CORBA.NameValuePair;

public class Eutils {

    public static Logger logger = Logger.getLogger(Eutils.class.getName());
    //private static String response;

    //private static String pubmedId;

    // http://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi?db=pubmed&id=15852344&report=docsum&mode=text


    public static String getPubMedSummary(String pubmedId) {
        String baseUrl = "http://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi";
        Map<String, String> parameters = new HashMap();


        parameters.put("db","pubmed");
        parameters.put("id","15852344");
        parameters.put("report","docsum");
        parameters.put("mode","text");

        // call make get request

        //pubmedId.makeGetRequest();

        InputStream response = makeGetRequest(baseUrl, parameters);


        // get the summary out from input stream



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

	//    private static List<String> parsePmids(InputStream response)
	//            throws XMLStreamException, FactoryConfigurationError {
	//        List<String> pmids = new ArrayList<String>();
	//
	//        XMLStreamReader parser = XMLInputFactory.newInstance()
	//                .createXMLStreamReader(response);
	//        while (parser.hasNext()) {
	//            parser.next();
	//            if (parser.isStartElement() && parser.getLocalName().equals("Id")) {
	//                parser.next();
	//                String pmid = parser.getText();
	//                pmids.add(pmid);
	//            }
	//        }
	//        return pmids;
	//    }

    // TODO pull the article title too not just pmid

	//}

	// String query = "Lord[Author] AND semantic similarity[Title] AND Semantics[MeSH Major Topic]";


	// String tester = (String) iterator.next();

	//String tester = dbc.getContactkeyaccessionvalue().keySet().toString();

	// to get the keys one by one for(String key : dbc.getContactkeyaccessionvalue().keySet())

	//String query = "Csordas[Author] AND mitochondrial transfer[Title]";

	public static void main(String[] args) {
		//Map<String, String> params = new HashMap<String, String>();
		//String baseUrl = "http://eutils.ncbi.nlm.nih.gov/entrez/eutils/esearch.fcgi";
		//String query = "Lord[Author] AND semantic similarity[Title] AND Semantics[MeSH Major Topic]";

		//params.put("db", "pubmed");
		//params.put("term", query);
		//InputStream response = makeGetRequest(baseUrl, params);


        //System.out.println(getPubMedSummary(pubmedId));

		//		try {
		//			List<String> pmids = parsePmids(response);
		//			System.out.println(pmids);
		//		} catch (XMLStreamException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		} catch (FactoryConfigurationError e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
	}

}


