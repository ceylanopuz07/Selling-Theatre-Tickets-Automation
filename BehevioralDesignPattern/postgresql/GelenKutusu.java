package postgresql;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import org.postgresql.translation.messages_ja;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;

public  class GelenKutusu extends JFrame implements  GelenKutusuListele{

	private static final JTextComponent GelenMesaj = null;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GelenKutusu frame = new GelenKutusu();
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
	public GelenKutusu() {
		initComponents();
	
		
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
		
		JTextArea GelenMesaj = new JTextArea();
		GelenMesaj.setBounds(12, 58, 493, 249);
		panel.add(GelenMesaj);
		
		JLabel gelenMesaj = new JLabel("Gelen Mesaj :");
		gelenMesaj.setFont(new Font("Tahoma", Font.BOLD, 15));
		gelenMesaj.setBounds(12, 13, 130, 28);
		panel.add(gelenMesaj);
	}

	 

	private void initComponents() {
	// TODO Auto-generated method stub
		JPanel panel = new JPanel();
		contentPane = new JPanel();
		JLabel gelenMesaj = new JLabel("Gelen Mesaj :");
		JTextArea txtrMesajlistele = new JTextArea();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
	}



	@Override
	public void onMessage(String mesaj) {
		// TODO Auto-generated method stub
		
		GelenMesaj.setText(mesaj);
		
	}
}


