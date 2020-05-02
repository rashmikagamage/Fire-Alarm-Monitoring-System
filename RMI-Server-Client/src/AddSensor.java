

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.rmi.Naming;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class AddSensor extends JFrame {


	private JPanel contentPane;
	public JTextField floorNoTextField;
	public JTextField roomNoTextField;
	public boolean active;
	static AddSensor frame = new AddSensor();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AddSensor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddSensor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		floorNoTextField = new JTextField();
		floorNoTextField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent evt) {

				// Input validation for floorNo to enter only numbers
				char c = evt.getKeyChar();

				if (floorNoTextField.getText().contains(".")) {

					if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
						evt.consume();
					}
				} else {
					if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE
							|| c == '.')) {
						evt.consume();
					}
				}
			}
		});

		floorNoTextField.setBounds(271, 87, 210, 27);
		contentPane.add(floorNoTextField);
		floorNoTextField.setColumns(10);
		roomNoTextField = new JTextField();
		roomNoTextField.addKeyListener(new KeyAdapter() {

			// Inpput validation for roomNo
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();

				if (roomNoTextField.getText().contains(".")) {

					if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {

						evt.consume();
					}
				} else {
					if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE
							|| c == '.')) {

						evt.consume();
					}
				}
			}
		});

		roomNoTextField.setBounds(271, 125, 210, 27);
		contentPane.add(roomNoTextField);
		roomNoTextField.setColumns(10);

		JLabel lblFloorNo = new JLabel("Floor No");
		lblFloorNo.setBounds(180, 87, 65, 27);
		contentPane.add(lblFloorNo);

		JLabel lblRoomNo = new JLabel("Room No");
		lblRoomNo.setBounds(180, 131, 65, 14);
		contentPane.add(lblRoomNo);

		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(211, 211, 211));
		btnAdd.setBounds(271, 229, 210, 33);

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String floorNumber, roomNumber;

				try {

					// If input fields are empty display an error
					if (floorNoTextField.getText().isBlank() || roomNoTextField.getText().isBlank()) {

						JFrame f = new JFrame();
						JOptionPane.showMessageDialog(f, "Empty Fields");
					}

					else {
						
						// Getting input fields and assigning them to variables
						floorNumber = floorNoTextField.getText();
						roomNumber = roomNoTextField.getText();

						// Getting remote object
						Temperature_Sensor_Interface obj = (Temperature_Sensor_Interface) Naming
								.lookup("//localhost/sensor");

						// Calling add sensor method in remote object
						obj.addSensor(active, floorNumber, roomNumber, 0, 0);

						// Displaying added Dialog
						JFrame f = new JFrame();
						JOptionPane.showMessageDialog(f, "Sensor Added");

						// Setting input fields empty
						floorNoTextField.setText("");
						roomNoTextField.setText("");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}

		});
		contentPane.add(btnAdd);

		JButton btnEdit = new JButton("Edit / Delete");
		btnEdit.setBackground(new Color(211, 211, 211));
		btnEdit.setBounds(587, 29, 114, 27);
		btnEdit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// Dispose current windpow and open editSensor Window
				frame.dispose();
				EditSensor editSensor = new EditSensor();
				editSensor.setVisible(true);
				

			}
		});

		contentPane.add(btnEdit);

		JCheckBox activeSelect = new JCheckBox("Activate");
		activeSelect.setBackground(new Color(240, 248, 255));
		activeSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Get selected value from checkBox
				if (activeSelect.isSelected()) {
					active = true;
				} else {
					active = false;
				}
			}
		});

		activeSelect.setBounds(343, 173, 87, 47);
		contentPane.add(activeSelect);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HomePage homePage = new HomePage();
				homePage.setVisible(true);
				frame.dispose();
			}
		});
		btnBack.setBounds(10, 11, 70, 27);
		contentPane.add(btnBack);

	}

}
