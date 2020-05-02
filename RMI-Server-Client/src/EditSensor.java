

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

import http_methods.Sensor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class EditSensor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField roomNoFind;
	private JTextField floorNoFind;
	private JTextField floorNoEdit;
	private JTextField roomNoEdit;
	private boolean active;
	private String floorNo;
	private String roomNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditSensor window = new EditSensor();
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
	public EditSensor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 248, 255));
		frame.getContentPane().setForeground(Color.CYAN);
		frame.setBackground(Color.CYAN);
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblSearchByFloor = new JLabel("Search by Floor and Room");
		lblSearchByFloor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSearchByFloor.setBounds(302, 11, 152, 32);
		frame.getContentPane().add(lblSearchByFloor);

		roomNoFind = new JTextField();
		roomNoFind.setBounds(298, 123, 167, 20);
		frame.getContentPane().add(roomNoFind);
		roomNoFind.setColumns(10);

		floorNoFind = new JTextField();
		floorNoFind.setBounds(298, 75, 167, 20);
		frame.getContentPane().add(floorNoFind);
		floorNoFind.setColumns(10);

		JLabel lblRoomNo = new JLabel("Room No");
		lblRoomNo.setBounds(191, 126, 62, 14);
		frame.getContentPane().add(lblRoomNo);

		JLabel lblFloorNo = new JLabel("Floor No");
		lblFloorNo.setBounds(191, 75, 62, 20);
		frame.getContentPane().add(lblFloorNo);

		JCheckBox activeSelect = new JCheckBox("");
		activeSelect.setBounds(438, 385, 27, 20);
		frame.getContentPane().add(activeSelect);

		JButton search = new JButton("Search");
		search.setBackground(new Color(211, 211, 211));
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Getting values from textfields
				floorNo = floorNoFind.getText();
				roomNo = roomNoFind.getText();

				try {
					// Creating remote object
					Temperature_Sensor_Interface obj = (Temperature_Sensor_Interface) Naming
							.lookup("//localhost/sensor");
					// call getOneSensorByID and store there the return object
					Sensor sensor = obj.getOneSensorByID(floorNo + roomNo);

					// Setting values to display to edit
					floorNoEdit.setText(sensor.getFloorNo());
					roomNoEdit.setText(sensor.getRoomNo());
					
					//Setting fields empty 
					floorNoFind.setText("");
					roomNoFind.setText("");

					if (sensor.isActive()) {
						activeSelect.setSelected(true);
					} else {
						activeSelect.setSelected(false);
					}

				} catch (Exception e1) {
					JFrame f = new JFrame();
					// if Null exception occured Dialog message will be displayed
					JOptionPane.showMessageDialog(f, "No Sensor Found");

				}

			}
		});
		search.setBounds(529, 102, 89, 23);
		frame.getContentPane().add(search);

		JLabel lblFloorNo_1 = new JLabel("Floor No");
		lblFloorNo_1.setBounds(207, 277, 62, 14);
		frame.getContentPane().add(lblFloorNo_1);

		JLabel lblRoomNo_1 = new JLabel("Room No");
		lblRoomNo_1.setBounds(207, 327, 62, 17);
		frame.getContentPane().add(lblRoomNo_1);

		floorNoEdit = new JTextField();
		floorNoEdit.setBounds(300, 274, 165, 20);
		frame.getContentPane().add(floorNoEdit);
		floorNoEdit.setColumns(10);

		roomNoEdit = new JTextField();
		roomNoEdit.setBounds(298, 324, 167, 20);
		frame.getContentPane().add(roomNoEdit);
		roomNoEdit.setColumns(10);

		JLabel lblSeeAndEdit = new JLabel("See and Edit Here");
		lblSeeAndEdit.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSeeAndEdit.setBounds(330, 222, 124, 23);
		frame.getContentPane().add(lblSeeAndEdit);

		JLabel lblActivateDeactivate = new JLabel("Activate / Deactivate");
		lblActivateDeactivate.setBounds(311, 387, 121, 18);
		frame.getContentPane().add(lblActivateDeactivate);
		
		//Event Listner for checkbox
		activeSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (activeSelect.isSelected()) {
					active = true;
				} else {
					active = false;
				}

			}
		});

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(211, 211, 211));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					// Creating remote object
					Temperature_Sensor_Interface obj = (Temperature_Sensor_Interface) Naming
							.lookup("//localhost/sensor");
					
					// Calling edit sensor methods
					obj.editSensor(floorNo + roomNo, activeSelect.isSelected(), floorNoEdit.getText().toString(),
							roomNoEdit.getText().toString());

					activeSelect.setSelected(false);
					floorNoEdit.setText("");
					roomNoEdit.setText("");

					// Updated success dialog
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f, "Sensor Updated");

				} catch (Exception ex) {
					System.out.println(ex);
				}

			}
		});
		btnUpdate.setBounds(529, 273, 89, 23);
		frame.getContentPane().add(btnUpdate);

		//Event Listner for delete button
		JButton delete = new JButton("Delete");
		delete.setBackground(new Color(211, 211, 211));
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Creating remote object
					Temperature_Sensor_Interface obj = (Temperature_Sensor_Interface) Naming
							.lookup("//localhost/sensor");

					// Calling delete method with ID , ID = roomNo + floorNo
					obj.deleteSensor(floorNoEdit.getText().toString() + roomNoEdit.getText().toString());

					// Display a dialog
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f, "Sensor Deleted");
					floorNoEdit.setText("");
					roomNoEdit.setText("");
					
				} catch (Exception e2) {

				}

			}
		});
		
		delete.setBounds(529, 323, 89, 23);
		frame.getContentPane().add(delete);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddSensor addSensor = new AddSensor();
				addSensor.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(24, 14, 74, 32);
		frame.getContentPane().add(btnNewButton);
		frame.setVisible(true);
	}
}
