package http_methods;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

	public class HTTP_POST {
		
		
		public  void POST(boolean active, String floorNo, String roomNo, int co2Level, int smokeLevel) 
				throws ClientProtocolException, IOException {
		
			// Building CloseableHttpClient
			JSONObject json = new JSONObject();
			json.put("active", active);
			json.put("floorNo", floorNo);
			json.put("roomNo", roomNo);
			json.put("co2Level", 0);
			json.put("smokeLevel", 0);
			
			System.out.println(json);
			System.out.println("============");
			
			// Building CloseableHttpClient
			CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		
				//Sending a Http Post request to REST api URL to Add sensor
			    HttpPost request = new HttpPost("http://localhost:4000/addSensor");
			    
			  //Converting json object to string and add it to parameters
			    StringEntity params = new StringEntity(json.toString());
			    System.out.println(json.toString());
			    request.addHeader("content-type", "application/json");
			    request.setEntity(params);
			    
			    //Execute the request and storing the response
			    HttpResponse response = httpClient.execute(request);
			    
			    //Printing status 
			    System.out.println(response.getStatusLine().toString());
			
		}
		
	}
