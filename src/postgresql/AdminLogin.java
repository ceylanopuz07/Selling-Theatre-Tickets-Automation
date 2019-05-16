package postgresql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AdminLogin {

	private JFrame frame;
	private JTextField kullanici_field;
	private JTextField sifree_field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin window = new AdminLogin();
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
	public AdminLogin() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	Connection connection = null;

	private void initialize() {

		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/TiyatroBilet",
					"postgres", "Zeyni15!");

			JOptionPane.showMessageDialog(null, "Connection succesful");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		frame = new JFrame();
		frame.getContentPane().setForeground(Color.RED);
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Tiyatro Bilet Sat\u0131\u015F Sistemi");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(158, 13, 337, 42);
		frame.getContentPane().add(lblNewLabel);

		kullanici_field = new JTextField();
		kullanici_field.setBounds(214, 94, 189, 36);
		frame.getContentPane().add(kullanici_field);
		kullanici_field.setColumns(10);

		sifree_field = new JTextField();
		sifree_field.setBounds(214, 164, 189, 36);
		frame.getContentPane().add(sifree_field);
		sifree_field.setColumns(10);

		JLabel kullanici_adý_field = new JLabel("Kullan\u0131c\u0131 ad\u0131");
		kullanici_adý_field.setFont(new Font("Tahoma", Font.PLAIN, 16));
		kullanici_adý_field.setBounds(74, 98, 84, 26);
		frame.getContentPane().add(kullanici_adý_field);

		JLabel sifre_field = new JLabel("\u015Eifre");
		sifre_field.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sifre_field.setBounds(84, 168, 84, 26);
		frame.getContentPane().add(sifre_field);

		JButton btnNewButton = new JButton("Admin Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AdminYap().setVisible(true);
				try {// Kayýtlý admin login yapsýn
					Class.forName("org.postgresql.Driver");
					Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/TiyatroBilet",
							"postgres", "Zeyni15!");

					String kullanici_adi = kullanici_field.getText();
					String admin_sifre = sifree_field.getText();

					String query = "select * from admin where kullanici_adý=? and sifre=?";
					PreparedStatement statement = connection.prepareStatement(query);

					statement.setString(1, kullanici_adi);
					statement.setString(2, admin_sifre);
					ResultSet set = statement.executeQuery();
					if (set.next()) {
						JOptionPane.showConfirmDialog(null, "Giriþ Baþarýlý");
					} else {
						JOptionPane.showConfirmDialog(null, "Email veya þifre mevcut deðil!");
					}

				} catch (SQLException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(288, 246, 143, 36);
		frame.getContentPane().add(btnNewButton);
	}
}
