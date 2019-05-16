package postgresql;

import static org.junit.Assert.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.junit.Test;

public class OyunEkleTest {

	@Test
	public void test() {
		Connect.getInstance();
		JLabel lblNewLabel = new JLabel();
		assertNotNull(lblNewLabel);
		JTextField oyunadi_field = new JTextField();
		assertNotNull(oyunadi_field);
		JTextField oyunturu_field = new JTextField();
		assertNotNull(oyunturu_field);
		JTextField oyunucreti_field = new JTextField();
		assertNotNull(oyunucreti_field);
		JTextField oyunaciklamasi_field = new JTextField();
		assertNotNull(oyunaciklamasi_field);
		JButton btnEkle = new JButton();
		assertNotNull(btnEkle);
	
	
	}
	
	
	

}
