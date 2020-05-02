package http_methods;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class HTTP_DELETE {

	public void DELETE(String sensorID) {

		Thread newThread = new Thread(() -> {
			try {
				// Building CloseableHttpClient
				CloseableHttpClient httpClient = HttpClientBuilder.create().build();

				try {
					// creating a http Delete Request
					HttpDelete request = new HttpDelete("http://localhost:4000/deleteSensor/" + sensorID);

					request.addHeader("content-type", "application/json");

					// Execute the request and storing response in HttpResponse object
					HttpResponse response = httpClient.execute(request);

					// Displaying the status code
					System.out.println(response.getStatusLine());

				} catch (Exception ex) {

					System.out.println(ex);

				} finally {

					try {
						// Closing the Client
						httpClient.close();

					} catch (IOException e) {

						e.printStackTrace();
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		newThread.start();

	}

}
