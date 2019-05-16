package postgresql;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class AdminYap extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminYap frame = new AdminYap();
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
	public AdminYap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("OYUN EKLE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new OyunEkle().setVisible(true);
			}
		});
		btnNewButton.setBounds(56, 39, 152, 95);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("OYUN S\u0130L");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new OyunSil().setVisible(true);
				
				
			}
		});
		btnNewButton_1.setBounds(307, 39, 152, 95);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("RAPORLAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Raporlar().setVisible(true);
			}
		});
		btnNewButton_2.setBounds(56, 174, 162, 95);
		contentPane.add(btnNewButton_2);
		
		JButton btnKullanclaraMesajGnder = new JButton("K.B\u0130LG\u0130LEND\u0130R");
		btnKullanclaraMesajGnder.setForeground(new Color(0, 0, 0));
		btnKullanclaraMesajGnder.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnKullanclaraMesajGnder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new KBilgilendir().setVisible(true);
			}
		});
		btnKullanclaraMesajGnder.setBounds(307, 174, 162, 95);
		contentPane.add(btnKullanclaraMesajGnder);
	}
}
