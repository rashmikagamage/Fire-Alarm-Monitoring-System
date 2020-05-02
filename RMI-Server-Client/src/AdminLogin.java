
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	static AdminLogin frame =new AdminLogin();;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AdminLogin();
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
	public AdminLogin() {

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setBounds(339, 185, 104, 26);
		contentPane.add(lblUserName);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(339, 230, 104, 26);
		contentPane.add(lblPassword);

		Image img = new ImageIcon(this.getClass().getResource("/login.png")).getImage().getScaledInstance(150, 150, 5);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(132, 130, 159, 180);
		contentPane.add(lblNewLabel);

		userName = new JTextField();
		userName.setBounds(460, 190, 153, 21);
		contentPane.add(userName);
		userName.setColumns(10);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uName = userName.getText().toLowerCase();
				String pWord = password.getText().toString();

				if (uName.equals("admin") && pWord.equals("admin")) {


					// Dispose current window
					frame.dispose();
					// Creaating a AddSensor object to make visible
					AddSensor addSensor = new AddSensor();
					addSensor.setVisible(true);

				} else {
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f, "Invalid Cardential");
				}

			}
		});
		btnNewButton.setBounds(494, 287, 89, 23);
		contentPane.add(btnNewButton);
		
		password = new JPasswordField();
		password.setBounds(460, 235, 153, 21);
		contentPane.add(password);

	}
}
