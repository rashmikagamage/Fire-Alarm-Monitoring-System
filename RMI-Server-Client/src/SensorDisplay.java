

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.rmi.Naming;
import java.util.List;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;
import http_methods.Sensor;
import javax.swing.JButton;

public class SensorDisplay extends JFrame {

	static JFrame frame;
	static JPanel panel;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SensorDisplay window = new SensorDisplay();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	/**
	 * Create the application.
	 */
	public SensorDisplay() {
	
		initialize();
		
		try {

			// Creating remote object
			Temperature_Sensor_Interface obj = (Temperature_Sensor_Interface) Naming
					.lookup("//localhost/sensor");

			// Creating Swing Timer object
			Timer t = new Timer(0, null);

			t.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					try {
							
						// Calling getSensor to get all the sensors and store in a List
						List<Sensor> sensorsList = obj.getSensor();
						displaySensors(sensorsList);
						frame.setBounds(100, 100, 750, 500);
					} catch (Exception ex) {

					}
				}
			});

			t.setRepeats(true); // Set timer repeat as True
			t.setDelay(30000); // run thread every 30 seconds repeatedly 
			t.start();

		} catch (Exception ex) {

			// Error dialog if an exception occurs
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, "Error Occured");

			ex.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 248, 255));
		frame.setVisible(true);
		frame.getContentPane().setForeground(new Color(0, 0, 128));
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel.setBounds(40, 76, 663, 374);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 3, 2, 2));

		JLabel lblSmokeSensor = new JLabel("See Sensors Here!");
		lblSmokeSensor.setFont(new Font("Corbel Light", Font.BOLD, 22));
		lblSmokeSensor.setBounds(282, 11, 187, 39);
		frame.getContentPane().add(lblSmokeSensor);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			HomePage homePage = new HomePage();
			homePage.setVisible(true);
			frame.dispose();
				
			}
		});
		btnBack.setBounds(22, 21, 72, 29);
		frame.getContentPane().add(btnBack);

	}

	public static void displaySensors(List<Sensor> sensorList) {

		frame.setBounds(100, 100, 751, 500);
		
		//Removing previous items from panel
		panel.removeAll();

		//Looping through the sensor List
		
		for (Sensor s : sensorList) {
			
			//Creating a component
			SensorComponent component = new SensorComponent(s.getFloorNo(), s.getRoomNo(), s.getCo2Level(),
					s.getSmokeLevel(), s.isActive());
			component.setVisible(true);
			
			//Add component to panel
			panel.add(component);
		
		}

	}
	
	
}
