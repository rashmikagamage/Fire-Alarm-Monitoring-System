
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage extends JFrame {

	private JPanel contentPane;
	static HomePage frame = new HomePage();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new HomePage();
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
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSmokeMo = new JLabel("Fire Sensor Monitoring");
		lblSmokeMo.setForeground(new Color(255, 69, 0));
		lblSmokeMo.setFont(new Font("Cambria Math", Font.PLAIN, 28));
		lblSmokeMo.setBounds(215, 32, 283, 57);
		contentPane.add(lblSmokeMo);
		
		JButton Admin = new JButton("Admin");
		Admin.setBackground(new Color(250, 240, 230));
		Admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			AdminLogin adminLogin = new AdminLogin();
			adminLogin.setVisible(true);
			frame.dispose();
				
			}
		});
		Admin.setBounds(373, 151, 164, 57);
		contentPane.add(Admin);
		
		JButton display = new JButton("View Sensors");
		display.setBackground(new Color(250, 240, 230));
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				//Dispose current window
				frame.dispose();
				
				//Creating a sensorDisplay object to make visible
				SensorDisplay sensorDisplay = new SensorDisplay();
				sensorDisplay.setVisible(true);
				
				
				
			}
		});
		display.setBounds(373, 241, 164, 57);
		contentPane.add(display);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(147, 128, 164, 200);
		contentPane.add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("/fire.png")).getImage().getScaledInstance(150, 150, 5);
		lblNewLabel.setIcon(new ImageIcon(img));
	}
}
