package postgresql;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class MusteriBilgieri extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField m_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusteriBilgieri frame = new MusteriBilgieri();
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
	Connection connectin=null;
	public MusteriBilgieri() {
		
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
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(213, 43, 357, 272);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton giris_field = new JButton("Giri\u015F");
		giris_field.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Class.forName("org.postgresql.Driver");
					Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/TiyatroBilet",
							"postgres", "Zeyni15!");
					String query = "select * from musteri where m_id=?";
					PreparedStatement statement = connection.prepareStatement(query);
					statement.setInt(1, Integer.parseInt(m_id.getText()));
					ResultSet set = statement.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(set));
					m_id.setText("");
					

				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
				
				
			
		});
		giris_field.setFont(new Font("Tahoma", Font.BOLD, 15));
		giris_field.setBounds(85, 156, 97, 25);
		contentPane.add(giris_field);
		
		m_id = new JTextField();
		m_id.setBounds(41, 102, 97, 22);
		contentPane.add(m_id);
		m_id.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("M\u00FC\u015Fteri ID Numaran\u0131z\u0131 Giriniz!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(12, 56, 189, 22);
		contentPane.add(lblNewLabel);
	}
}
