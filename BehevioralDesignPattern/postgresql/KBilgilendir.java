package postgresql;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class KBilgilendir extends JFrame {

	private JPanel contentPane;
	private JTextField txtmesaj;
	private ArrayList<GelenKutusuListele> mesajýListele = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KBilgilendir frame = new KBilgilendir();
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

	@SuppressWarnings("unchecked")
	public KBilgilendir() {
		initComponents();
		setTitle("Kullanýcý Bilgilendir");
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 582, 353);
		contentPane.add(panel);
		panel.setLayout(null);

		txtmesaj = new JTextField();
		txtmesaj.setBounds(12, 6, 443, 39);
		panel.add(txtmesaj);
		txtmesaj.setColumns(10);

		JButton kullanici_ekle = new JButton("K.Ekle");
		kullanici_ekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			

				int numberOfCostumers = 0;

				try {

					numberOfCostumers = Integer.parseInt(txtmesaj.getText());

				} catch (NumberFormatException e2) {
					// TODO: handle exception

					for (int i = 0; i < numberOfCostumers; i++) {

						GelenKutusu gelenkutusu = new GelenKutusu();

						gelenkutusu.setLocation(i, (i + 20));
						gelenkutusu.setTitle("Gelen Kutusu" + (i + 1));
						gelenkutusu.setVisible(true);

						mesajýListele.add(gelenkutusu);

					}

				}

			}

		});

		kullanici_ekle.setBounds(467, 6, 97, 39);
		panel.add(kullanici_ekle);

		JTextArea mesajtxt = new JTextArea();
		mesajtxt.setBounds(12, 58, 493, 212);
		panel.add(mesajtxt);

		JButton mesaj_gonder = new JButton("Mesaj G\u00F6nder");
		mesaj_gonder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mesaj = mesajtxt.getText();
				if (mesaj.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Mesaj kutusu boþ :'( ");

				} else {
					JOptionPane.showMessageDialog(null, "Bilgiler Ýletildi :) ");

					return;
				}

				for (GelenKutusuListele gelenkutusunulistele : mesajýListele) {
					gelenkutusunulistele.onMessage(mesaj);

					;

				}

			}
		});
		mesaj_gonder.setBounds(419, 283, 137, 39);
		panel.add(mesaj_gonder);
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		contentPane = new JPanel();
		JPanel panel = new JPanel();
		// textField = new JTextField();
		JButton kullanici_ekle = new JButton("K.Ekle");

	}

	public void onMessage(String mesaj) {
		// txtmesaj.setText(message);
	}

}
