package postgresql;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class OyunSil extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OyunSil frame = new OyunSil();
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
	private JScrollPane scrollPane;
	private JTextField idfield;
	private JLabel lblNewLabel_5;

	public OyunSil() {

		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/TiyatroBilet",
					"postgres", "Zeyni15!");

			//JOptionPane.showMessageDialog(null, "Connection succesful");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(333, 76, 637, 418);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton listele_field = new JButton("T\u0130YATRO OYUNLARINI L\u0130STELE");
		listele_field.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Class.forName("org.postgresql.Driver");
					Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/TiyatroBilet",
							"postgres", "Zeyni15!");
					String query = "select * from OYUN";
					PreparedStatement statement = connection.prepareStatement(query);
					ResultSet set = statement.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(set));

				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		listele_field.setFont(new Font("Tahoma", Font.BOLD, 16));
		listele_field.setBounds(493, 13, 351, 45);
		contentPane.add(listele_field);

		JButton btnNewButton = new JButton("OYUNU S\u0130L");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("org.postgresql.Driver");
					Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/TiyatroBilet",
							"postgres", "Zeyni15!");
					String query = "delete  from OYUN where oid=?";
					PreparedStatement statement = connection.prepareStatement(query);
					statement.setInt(1, Integer.parseInt(idfield.getText()));
					statement.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Baþarýyla silindi");
					idfield.setText("");
					/*oyunadi.setText("");
					oyunturu.setText("");
					fiyati.setText("");
					lokasyon.setText("");
					aciklmasi.setText("");**/
					
					statement.close();

				} catch (ClassNotFoundException | SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(117, 302, 127, 75);
		contentPane.add(btnNewButton);
		
		idfield = new JTextField();
		idfield.setColumns(10);
		idfield.setBounds(131, 194, 113, 31);
		contentPane.add(idfield);
		
		lblNewLabel_5 = new JLabel("OYUN ID");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(12, 200, 69, 16);
		contentPane.add(lblNewLabel_5);
	}
}
