
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import http_methods.*;
import sms_email_services.GetUserDetails;
import sms_email_services.SendEmail;
import sms_email_services.SendSMS;
import sms_email_services.UserDetails;

public class Temperature_Sensor_Impl extends UnicastRemoteObject implements Temperature_Sensor_Interface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	protected Temperature_Sensor_Impl() throws RemoteException {
		super();

	}

	// Method to add new Sensors
	public void addSensor(boolean active, String floorNo, String roomNo, int co2Level, int smokeLevel)
			throws Exception {

		// Creating a object of HTTP_POST and call post method with parameters
		HTTP_POST httpPost = new HTTP_POST();

		httpPost.POST(active, floorNo, roomNo, co2Level, smokeLevel);

	}

	// Method to edit Sensors
	public void editSensor(String updateID, boolean active, String floorNo, String roomNo)
			throws Exception {

		// Creating a object of HTTP_PATCH and call patch method with parameters
		HTTP_PATCH httpPatch = new HTTP_PATCH();

		httpPatch.UPDATE(updateID, active, floorNo, roomNo);

	}

	// Method to get all Sensors
	public List<Sensor> getSensor() throws Exception {

		// Calling the method in HTTP_GET class
		HTTP_GET httpGet = new HTTP_GET();

		// Storing return values in a list
		List<Sensor> sensors = httpGet.GET();

		// Return sensors
		return sensors;
	}

	// Method to delete one Sensor with given ID
	public void deleteSensor(String sensorID) throws Exception {

		// Calling delete in HTTP_DELETE with ID
		HTTP_DELETE httpDelete = new HTTP_DELETE();

		httpDelete.DELETE(sensorID);

	}

	// Method to get one Sensor with given ID
	public Sensor getOneSensorByID(String ID) throws Exception {

		// Calling GET_ONE in HTTP_GET_ONE with ID
		HTTP_GET_ONE getOne = new HTTP_GET_ONE();

		Sensor sensor = getOne.GET(ID);

		// Return the sensor
		return sensor;
	}

}
