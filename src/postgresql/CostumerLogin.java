package postgresql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CostumerLogin {

	private JFrame frame;
	private JTextField e_mail_field;
	private JTextField sifre;
	private JTextField add_field;
	private JTextField emaill_field;
	private JTextField siffre_field;
	private JTextField telnoo_field;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CostumerLogin window = new CostumerLogin();
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
	public CostumerLogin() {
		initialize();

	}

	Connection connection = null;

	public void CreateTableNew() {

		try {
			DatabaseMetaData dmd = connection.getMetaData();
			ResultSet set = dmd.getTables(null, null, "kullanicitablosu", null);
			if (set.next()) {
				// Eðer kullanýcý kayýtlý ise
			} else {

				String create_table = "Create table kullanicitablosu(" + "ad varchar(15), " + "email varchar(30),"
						+ "sifre varchar(10), " + "telno text))";
				PreparedStatement statement = connection.prepareStatement(create_table);
				statement.executeUpdate();

				JOptionPane.showMessageDialog(null, "Baþarýyla oluþturuldu tablo");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Connect conn= new Connect();
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/TiyatroBilet",
					"postgres", "Zeyni15!");
			

		//	JOptionPane.showMessageDialog(null, "Connection succesful");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel alreadyUser = new JLabel("Already User");
		alreadyUser.setFont(new Font("Tahoma", Font.PLAIN, 22));
		alreadyUser.setBounds(392, 57, 149, 27);
		frame.getContentPane().add(alreadyUser);

		JButton account_field = new JButton("Create Account");
		account_field.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
			}
		});
		account_field.setBounds(29, 103, 207, 35);
		frame.getContentPane().add(account_field);

		e_mail_field = new JTextField();
		e_mail_field.setBounds(386, 109, 155, 22);
		frame.getContentPane().add(e_mail_field);
		e_mail_field.setColumns(10);

		sifre = new JTextField();
		sifre.setBounds(386, 144, 155, 22);
		frame.getContentPane().add(sifre);
		sifre.setColumns(10);

		JLabel email_field = new JLabel("E-mail");
		email_field.setBounds(296, 109, 56, 16);
		frame.getContentPane().add(email_field);

		JLabel sifre_field = new JLabel("\u015Eifre");
		sifre_field.setBounds(296, 147, 56, 16);
		frame.getContentPane().add(sifre_field);

		JButton giris_field = new JButton("Giri\u015F");
		giris_field.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MusteriYap().setVisible(true);
				try {// Kayýtlý müþteri login yapsýn
					Class.forName("org.postgresql.Driver");
					Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/TiyatroBilet",
							"postgres", "Zeyni15!");

					String email = e_mail_field.getText();
					String m_sifre = sifre.getText();

					String query = "select * from musteri where email=? and m_sifre=?";
					PreparedStatement statement = connection.prepareStatement(query);

					statement.setString(1, email);
					statement.setString(2, m_sifre);
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
		giris_field.setBounds(442, 189, 97, 25);
		frame.getContentPane().add(giris_field);

		JLabel newUser = new JLabel("New User");
		newUser.setFont(new Font("Tahoma", Font.PLAIN, 22));
		newUser.setBounds(72, 55, 122, 30);
		frame.getContentPane().add(newUser);

		panel = new JPanel();
		panel.setVisible(false);
		// make variable..
		panel.setBounds(12, 151, 272, 202);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		add_field = new JTextField();
		add_field.setBounds(97, 13, 116, 22);
		panel.add(add_field);
		add_field.setColumns(10);

		emaill_field = new JTextField();
		emaill_field.setBounds(97, 50, 116, 22);
		panel.add(emaill_field);
		emaill_field.setColumns(10);

		siffre_field = new JTextField();
		siffre_field.setBounds(97, 89, 116, 22);
		panel.add(siffre_field);
		siffre_field.setColumns(10);

		telnoo_field = new JTextField();
		telnoo_field.setBounds(97, 124, 116, 22);
		panel.add(telnoo_field);
		telnoo_field.setColumns(10);

		JLabel ad_field = new JLabel("Ad");
		ad_field.setBounds(29, 16, 56, 16);
		panel.add(ad_field);

		JLabel Email_field = new JLabel("Yeni Email");
		Email_field.setBounds(12, 53, 73, 16);
		panel.add(Email_field);

		JLabel Sifre_field = new JLabel("Yeni \u015Eifre");
		Sifre_field.setBounds(12, 92, 56, 16);
		panel.add(Sifre_field);

		JLabel telno_field = new JLabel("Telefon no");
		telno_field.setBounds(12, 127, 73, 16);
		panel.add(telno_field);

		JButton hesap_olustur = new JButton("Hesap olu\u015Ftur");
		hesap_olustur.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new MusteriYap().setVisible(true);
				try {//yeni kayýtlarý oluþtursun
					Class.forName("org.postgresql.Driver");
					Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/TiyatroBilet",
							"postgres", "Zeyni15!");

					String insert_data = "insert into kullanicitablosu values (?,?,?,?)";
					PreparedStatement statement = connection.prepareStatement(insert_data);
					statement.setString(1, add_field.getText());
					statement.setString(2, emaill_field.getText());
					statement.setString(3, siffre_field.getText());
					statement.setString(4, telnoo_field.getText());

					int data_entered = statement.executeUpdate();

					if (data_entered > 0) {
						JOptionPane.showMessageDialog(null, "Kayýt baþarýyla oluþturuldu.(:");
						frame.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "Kayýt oluþturulamadý, tekrar deneyin!");

					}
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		hesap_olustur.setBounds(125, 164, 135, 25);
		panel.add(hesap_olustur);
	}

	



	

	
}
