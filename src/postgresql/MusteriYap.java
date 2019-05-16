package postgresql;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Checkbox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.ImageIcon;

public class MusteriYap extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusteriYap frame = new MusteriYap();
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
	public MusteriYap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setToolTipText("\u00C7\u0131k\u0131\u015F");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Ho\u015F Geldiniz");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(198, 51, 178, 32);
		contentPane.add(lblNewLabel);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("Biletler");
		menuBar.setBounds(0, 0, 582, 38);
		contentPane.add(menuBar);

		JMenu mnNewMenu_2 = new JMenu("Profil");
		menuBar.add(mnNewMenu_2);

		JMenuItem mn�tmNewMenuItem_3 = new JMenuItem("M\u00FC\u015Fteri Bilgileri");
		mn�tmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MusteriBilgieri().setVisible(true);
			}
		});
		mnNewMenu_2.add(mn�tmNewMenuItem_3);

		JMenuItem mn�tmNewMenuItem_2 = new JMenuItem("Gelen Kutusu");
		mn�tmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GelenKutusu().setVisible(true);
			}
		});
		mnNewMenu_2.add(mn�tmNewMenuItem_2);

		JMenuItem mn�tmk = new JMenuItem("\u00C7\u0131k\u0131\u015F");
		mn�tmk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		mnNewMenu_2.add(mn�tmk);

		JMenu mnNewMenu = new JMenu("Biletler");
		menuBar.add(mnNewMenu);

		JMenuItem mn�tmNewMenuItem = new JMenuItem("Biletlerim");
		mn�tmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Biletlerim().setVisible(true);

			}
		});
		mnNewMenu.add(mn�tmNewMenuItem);

		JMenuItem mn�tmNewMenuItem_1 = new JMenuItem("Yeni Bilet");
		mn�tmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new YeniBilet().setVisible(true);
			}
		});
		mnNewMenu.add(mn�tmNewMenuItem_1);
	}
}
