package http_methods;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

public class HTTP_PATCH {

	public void UPDATE(String updateID,boolean active, String floorNo, String roomNo) 
			throws ClientProtocolException, IOException {
	
		//Creating json object and add all the values into it
		JSONObject json = new JSONObject();
		json.put("active", active);
		json.put("floorNo", floorNo);
		json.put("roomNo", roomNo);
		
		// Building CloseableHttpClient
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
				
			//Sending a Http patch request to REST api URL to update sensors
		    HttpPatch request = new HttpPatch("http://localhost:4000/updateSensor/"+updateID);
		    
		    //Converting json object to string and add it to parameters
		    StringEntity params = new StringEntity(json.toString());
		    
		    request.addHeader("content-type", "application/json");
		    request.setEntity(params);
		    
		    //Execute the request and storing the response
		    HttpResponse response = httpClient.execute(request);
		    
		    //Printing status 
		    System.out.println(response.getStatusLine().toString());
		   

	}
	
}
