
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import sms_email_services.UserDetails;

import javax.swing.border.BevelBorder;

public class SensorComponent extends JPanel {

	/**
	 * Create the panel.
	 */
	public SensorComponent(String floorNo, String roomNo, int co2Level, int smokeLevel, Boolean status) {
		setBorder(new LineBorder(new Color(0, 139, 139), 1, true));

		// Status is Active and CO2 level or Smoke level is higher than Five 
		// Component is RED
		if (status == true && (co2Level > 5 || smokeLevel > 5)) {
			
			setBackground(new Color(255, 160, 122));

			// If sensor is active and smoke and CO2 levels are below 6
		} else {

			setBackground(new Color(248, 248, 255));
		}

		setForeground(Color.WHITE);
		setLayout(null);

		String co2LevelS;
		String smokeLevelS;

		// if Sensor is inactive CO2 and Smoke level will be displayed as 0
		if (status == false) {
			co2LevelS = "0";
			smokeLevelS = "0";
		} else {
			co2LevelS = Integer.toString(co2Level);
			smokeLevelS = Integer.toString(smokeLevel);
		}

		String activateStatus;

		// setting sensor status to display
		if (status) {
			activateStatus = "Activate";
		} else {
			activateStatus = "Inactive";
		}

		JLabel lblNewLabel_1 = new JLabel(roomNo);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(154, 31, 62, 14);
		add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel(floorNo);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(154, 1, 73, 19);
		add(lblNewLabel);

		JLabel label = new JLabel(co2LevelS);
		label.setFont(new Font("Dialog", Font.PLAIN, 14));
		label.setBounds(152, 56, 42, 14);
		add(label);

		JLabel lblCoLevel = new JLabel("CO2 Level    :");
		lblCoLevel.setBounds(60, 58, 73, 14);
		add(lblCoLevel);

		JLabel lblSmoke = new JLabel("Smoke Level :");
		lblSmoke.setBounds(60, 81, 73, 19);
		add(lblSmoke);

		JLabel label_2 = new JLabel(smokeLevelS);
		label_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_2.setBounds(154, 79, 42, 18);
		add(label_2);

		JLabel lblFloorNo = new JLabel("Floor No :");
		lblFloorNo.setBounds(60, 3, 62, 16);
		add(lblFloorNo);

		JLabel lblRoomNo = new JLabel("Room No :");
		lblRoomNo.setBounds(59, 33, 62, 13);
		add(lblRoomNo);

		JLabel label_1 = new JLabel(activateStatus);
		label_1.setBackground(new Color(204, 255, 255));
		label_1.setBounds(79, 135, 73, 26);
		add(label_1);

	}
}
