package postgresql;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class Biletlerim extends JFrame {

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
					Biletlerim frame = new Biletlerim();
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
	public Biletlerim() {
		
		
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
		setBounds(100, 100, 1000, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(440, 13, 530, 237);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		m_id = new JTextField();
		m_id.setBounds(39, 88, 116, 22);
		contentPane.add(m_id);
		m_id.setColumns(10);
		
		JButton btnNewButton = new JButton("\u00D6\u011EREN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("org.postgresql.Driver");
					Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/TiyatroBilet",
							"postgres", "Zeyni15!");
					
					String query = "select * from bilet where m_id=?";
					PreparedStatement statement = connection.prepareStatement(query);
					statement.setInt(1, Integer.parseInt(m_id.getText()));
					ResultSet set = statement.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(set));
					m_id.setText("");
					

				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
				
				
				
				
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(100, 128, 97, 38);
		contentPane.add(btnNewButton);
		
		JTextPane txtpnBiletIdsinirenebilmek = new JTextPane();
		txtpnBiletIdsinirenebilmek.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnBiletIdsinirenebilmek.setText("Bilet ID'sini \u00D6\u011Frenebilmek \u0130\u00E7in L\u00FCtfen M\u00FC\u015Fteri ID'nizi Giriniz!");
		txtpnBiletIdsinirenebilmek.setBounds(12, 13, 255, 50);
		contentPane.add(txtpnBiletIdsinirenebilmek);
	}
}
