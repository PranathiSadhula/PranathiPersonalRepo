/*
 * Author : Pranathi Sadhula
 * ApiQAExecutor.java is implementation of ApiQAController.java
 * 
 */
package api.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;


import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;

import api.controller.response.ApiResponse;
import api.controller.response.ApiResponseValidator;

/**
 * The Class ApiQAExecutor.
 */
public class ApiQAExecutor implements ApiQAController {

	/** The client. */
	private HttpClient client;

	/** The infolog. */
	static Logger infolog = Logger.getLogger("infolog");

	/** The errorlog. */
	static Logger errorlog = Logger.getLogger("errorlog");

	public ApiResponseValidator response;

	/**
	 * Instantiates a new api QA executor.
	 *
	 * @param apiUrl
	 *            the api url
	 */
	public ApiQAExecutor() {
		client = HttpClientBuilder.create().build();
	}

	public ApiResponseValidator getResponse(String reqAdType, String reqUrl) {
		HttpGet request = new HttpGet(reqUrl);
		infolog.info(reqAdType + " ::" + reqUrl + "\n");

		HttpResponse response;
		/*
		 * The response object which holds the details of the response.
		 */
		ApiResponse apiResponse = new ApiResponse();
		StringBuffer responseString = new StringBuffer();
		try {
			/*
			 * Executing the GET operation
			 */
			response = client.execute(request);

			/*
			 * Obtaining the response body from the response stream.
			 */
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));
			// System.getProperty returns absolute path
			File responseFile = new File(System.getProperty("user.dir")
					+ "/data/response/" + reqAdType.toLowerCase());
			if (!responseFile.getParentFile().exists()) {
				responseFile.getParentFile().mkdirs();
			}
			// Remove if clause if you want to overwrite file
			// if(!responseFile.exists()){
			try {
				responseFile.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
			// }
			BufferedWriter bw = new BufferedWriter(new FileWriter(responseFile));
			String line = "";
			while ((line = rd.readLine()) != null) {
				responseString.append(line);
				bw.append(line);
				bw.append("\n");

			}

			bw.flush();
			bw.close();
			rd.close();

			/*
			 * Setting values for the response object
			 */
			/*
			 * try{ if(responseString.toString().contains("nextmessagecheck") )
			 * { throw new
			 * Exception("Exception in response : nextmessagecheck "); } }
			 * catch(Exception e) { getResponse(reqAdType, reqUrl); }
			 */
			apiResponse.setResponseBody(responseString.toString());
			apiResponse.setResponseCode(response.getStatusLine()
					.getStatusCode());
			apiResponse.setResponseMessage(response.getStatusLine()
					.getReasonPhrase());
			Header[] rheaders = response.getAllHeaders();
			for (Header header : rheaders) {
				apiResponse.setHeader(header.getName(), header.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * Returns the RestValidator object providing the response object
		 */
		this.response = new ApiResponseValidator(apiResponse);
		this.response.setRequestUrl(reqUrl);
		// return this.response = new ApiResponseValidator(apiResponse);
		return this.response;
	}

}
