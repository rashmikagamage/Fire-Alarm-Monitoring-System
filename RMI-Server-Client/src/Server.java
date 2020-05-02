
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import javax.swing.Timer;

import http_methods.HTTP_GET;
import http_methods.Sensor;
import sms_email_services.GetUserDetails;
import sms_email_services.SendEmail;
import sms_email_services.SendSMS;
import sms_email_services.UserDetails;


public class Server {
	

	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
		
		//Creating an object of Temperature_Sensor_Impl
		Temperature_Sensor_Impl obj = new Temperature_Sensor_Impl();
		//Registering in the registry
		Registry registry = LocateRegistry.getRegistry();
		//Bind object to the registry
		registry.bind("sensor", obj);
		System.out.println("Server Started"); 	
		
		//Timer object to schedule method call every five seconds
		Timer t= new Timer(0,null);
		
		//Action lister for timer object
		t.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					//Server gets sensors  every fifteen seconds
					  HTTP_GET http_get = new HTTP_GET(); 
					  List<Sensor> senosrs = http_get.GET();
					  
					  for (Sensor s : senosrs) {
						  if(s.getCo2Level()>5 || s.getSmokeLevel()>5) {
							  
							  //Getting user details of the relevant floor and room
							  GetUserDetails getUserDetails = new GetUserDetails();
							  UserDetails userDetails = getUserDetails.GetUserDetails(s.getFloorNo()+s.getRoomNo());
							  
							  	//This will be displayed in emails as the location to display in Email
								String location = "Floor : " + s.getFloorNo() + " Room : " + s.getRoomNo();
								System.out.println(location);
								
								//Creating SendEmail object and call send email method
								SendEmail sendEmail = new SendEmail();
								sendEmail.sendEmail(userDetails.getCustomerMail(),location, s.getCo2Level(), s.getSmokeLevel());
								
								//Creating SendSMS object and call sendSMS method
								SendSMS sendSMS = new SendSMS();
								sendSMS.sendSMS(userDetails.getCustomerPhone());
						  }
						  
					  }
					 
					
				} catch (Exception ex) {
					
					ex.printStackTrace();
					
				}
			}
		});
		
		//Set repeating
		t.setRepeats(true);
		//Set timer  to start the thread every for fifteen seconds
		t.setDelay(15000); 
		//Starting the timer
		t.start();
			
	}
}	


