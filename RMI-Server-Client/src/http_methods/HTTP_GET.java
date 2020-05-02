package http_methods;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class HTTP_GET {
	
	//REST api URL to get all sensors
	private final String URL = "http://localhost:4000/getAllSensors";
	
	public List<Sensor> sensors;

	public List<Sensor> GET() throws IOException, InterruptedException {

		// Building HttpClient
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().GET().header("accept", "application/json").uri(URI.create(URL))
				.build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		//Object mapper to map string with sensor object
		ObjectMapper mapper = new ObjectMapper();

		// Getting json String and map it Sensor class and generate sensor objects List
		sensors = mapper.readValue(response.body(), new TypeReference<List<Sensor>>() {
		});
		
		//Return sensors
		return sensors;
	}
	
}
