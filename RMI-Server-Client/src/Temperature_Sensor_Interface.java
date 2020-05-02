

import java.rmi.Remote;
import java.util.List;

import http_methods.Sensor;
import sms_email_services.UserDetails;

public interface Temperature_Sensor_Interface extends Remote {
	
		public void addSensor(boolean active,String floorNo,String roomNo,int co2Level,int smokeLevel) throws Exception;
		public void editSensor(String updateID,boolean active,String floorNo,String roomNo) throws Exception;
		public List<Sensor> getSensor() throws Exception;
		public void deleteSensor(String sensorID) throws Exception;
		public Sensor getOneSensorByID(String ID) throws Exception;
}
