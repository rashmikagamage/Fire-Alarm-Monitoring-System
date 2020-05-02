package sms_email_services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GetUserDetails {

	public UserDetails GetUserDetails(String location) throws IOException, InterruptedException {
		
		// api get user number and email with  URL + location
		String URL = "http://localhost:4000/getRoomDetails/"+11;

		// Building HttpClient
		HttpClient client = HttpClient.newHttpClient();
		
		//Crating http Get request and saving the response
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.header("accept", "application/json")			
				.uri(URI.create(URL))
				.build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
			 //Getting json String and map it UserDetails class and generate UserDetails object
			ObjectMapper mapper  = new ObjectMapper();
			UserDetails userDetails = mapper.readValue(response.body(),UserDetails.class );
			
				return userDetails;
		}

}
