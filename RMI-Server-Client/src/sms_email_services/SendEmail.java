package sms_email_services;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

public class SendEmail {

	public void sendEmail(String email, String location, int co2Level, int smokeLevel)
			throws ClientProtocolException, IOException {

		System.out.println("In send Email");
		System.out.println(email+ " " + location + " " + co2Level);
		// Starting New Thread
		Thread newThread = new Thread(() -> {

			// Building CloseableHttpClient
			JSONObject json = new JSONObject();
			json.put("receiverEmail", email);
			json.put("location", location);
			json.put("co2Level", co2Level);
			json.put("smokeLevel", smokeLevel);

			// Building CloseableHttpClient
			CloseableHttpClient httpClient = HttpClientBuilder.create().build();

			// Sending a Http Post request to REST api URL to send email
			HttpPost request = new HttpPost("http://localhost:4000/sendEmail");

			try {

				// Converting json object to string and add it to parameters
				StringEntity params = new StringEntity(json.toString());
				System.out.println(json.toString());
				request.addHeader("content-type", "application/json");
				request.setEntity(params);

				// Execute the request and storing the response
				HttpResponse response = httpClient.execute(request);

				// Printing status
				System.out.println(response.getStatusLine().toString());

			} catch (Exception e) {

				e.printStackTrace();
			}

		});
		newThread.start();

	}

}
