package postgresql;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class OyunEkle extends JFrame {

	private JPanel contentPane;
	private JTextField oyunadi_field;
	private JTextField oyunturu_field;
	private JTextField oyunucreti_field;
	private JTextField oyunaciklamasi_field;
	private JTextField lokasyon_field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OyunEkle frame = new OyunEkle();
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
	Connection connection = null;
	private JTextField id;
	

	public void CreateTableNew() {

		try {
			DatabaseMetaData dmd = connection.getMetaData();
			ResultSet set = dmd.getTables(null, null, "oyunekle", null);
			if (set.next()) {
				// Eðer oyun varsa
			} else {

				String create_table = "create table oyun(oid seial primary key, oyun_adi varchar (30), "
						+ "oyun_turu text,"
						+ " oyun_ucreti int, "
						+"lokasyon varchar(50), "
						+ "oyun_aciklamasi varchar (100))";
				PreparedStatement statement = connection.prepareStatement(create_table);
				statement.executeUpdate();

				//JOptionPane.showMessageDialog(null, "Baþarýyla oluþturuldu tablo");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public OyunEkle() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/TiyatroBilet",
					"postgres", "Zeyni15!");

		//	JOptionPane.showMessageDialog(null, "Connection succesful");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Oyun Ad\u0131");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(57, 72, 81, 26);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Oyun T\u00FCr\u00FC");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(57, 111, 81, 28);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Oyun \u00DCcreti");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(57, 152, 97, 20);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Oyun A\u00E7\u0131klamas\u0131");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(57, 227, 139, 19);
		contentPane.add(lblNewLabel_3);

		oyunadi_field = new JTextField();
		oyunadi_field.setBounds(208, 78, 116, 22);
		contentPane.add(oyunadi_field);
		oyunadi_field.setColumns(10);

		oyunturu_field = new JTextField();
		oyunturu_field.setBounds(208, 115, 116, 22);
		contentPane.add(oyunturu_field);
		oyunturu_field.setColumns(10);

		oyunucreti_field = new JTextField();
		oyunucreti_field.setBounds(208, 152, 116, 22);
		contentPane.add(oyunucreti_field);
		oyunucreti_field.setColumns(10);

		oyunaciklamasi_field = new JTextField();
		oyunaciklamasi_field.setBounds(208, 226, 116, 22);
		contentPane.add(oyunaciklamasi_field);
		oyunaciklamasi_field.setColumns(10);
	

		JButton btnEkle = new JButton("Ekle");
		btnEkle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEkle.setForeground(Color.BLACK);
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Class.forName("org.postgresql.Driver");
					Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/TiyatroBilet",
							"postgres", "Zeyni15!");
					String insert_to_oyun = "insert into oyun values(?,?,?,?,?,?)";
					PreparedStatement statement = connection.prepareStatement(insert_to_oyun);
					statement.setInt(1, id.getColumns());
					statement.setString(2, oyunadi_field.getText());
					statement.setString(3, oyunturu_field.getText());
					statement.setInt(4, oyunucreti_field.getColumns());
					statement.setString(5,lokasyon_field.getText());
					statement.setString(6, oyunaciklamasi_field.getText());

					int data_entered = statement.executeUpdate();

					if (data_entered > 0) {
						JOptionPane.showMessageDialog(null, "Oyun baþarýyla eklendi.(:");
						
						id.setText("");
						oyunadi_field.setText("");
						oyunturu_field.setText("");
						oyunucreti_field.setText("");
						lokasyon_field.setText("");
						oyunaciklamasi_field.setText("");
						
					} else {
						JOptionPane.showMessageDialog(null, "Oyun eklenmedi, tekrar deneyin!");

					}

				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnEkle.setBounds(344, 273, 97, 42);
		contentPane.add(btnEkle);
		
		JLabel lblNewLabel_5 = new JLabel("Lokasyon");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(57, 198, 81, 16);
		contentPane.add(lblNewLabel_5);
		
		lokasyon_field = new JTextField();
		lokasyon_field.setBounds(208, 192, 116, 22);
		contentPane.add(lokasyon_field);
		lokasyon_field.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Tiyatro ID");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(57, 43, 81, 16);
		contentPane.add(lblNewLabel_4);
		
		id = new JTextField();
		id.setBounds(208, 40, 116, 22);
		contentPane.add(id);
		id.setColumns(10);
		//CreateTableNew();
	}
}
