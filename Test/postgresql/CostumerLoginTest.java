package postgresql;

import static org.junit.Assert.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.junit.Test;

public class CostumerLoginTest {

	@Test
	public void test() {
		Connect.getInstance();
		JFrame frame = new JFrame();
		assertNotNull(frame);
		JLabel alreadyUser = new JLabel("Already User");
		assertNotNull(alreadyUser);
		JButton account_field = new JButton("Create Account");
		assertNotNull(account_field);
		JTextField e_mail_field = new JTextField();
		assertNotNull(e_mail_field);
		JTextField sifre = new JTextField();
		assertNotNull(sifre);
		JButton giris_field = new JButton("Giri\u015F");
		assertNotNull(giris_field);
	
	
	
	}

}
