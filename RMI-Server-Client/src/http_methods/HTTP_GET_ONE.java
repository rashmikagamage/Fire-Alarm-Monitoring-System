package http_methods;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HTTP_GET_ONE {

	Sensor sensor = new Sensor();

	public Sensor GET(String ID) throws IOException, InterruptedException {

		// api get one user URL + ID
		String URL = "http://localhost:4000/getSensor/" + ID;

		// Building HttpClient
		HttpClient client = HttpClient.newHttpClient();

		// Crating http Get request and saving the response
		HttpRequest request = HttpRequest.newBuilder().GET().header("accept", "application/json").uri(URI.create(URL))
				.build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		// Getting json String and map it Sensor class and generate sensor object
		ObjectMapper mapper = new ObjectMapper();
		this.sensor = mapper.readValue(response.body(), Sensor.class);
		System.out.println(this.sensor);

		return sensor;

	}

}
