package postgresql;

import static org.junit.Assert.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import org.junit.Test;

import javafx.scene.control.Button;

public class AdminLoginTest {

	@Test
	public void test() {
		Connect.getInstance();
		JFrame frame = new JFrame();
		JTextField kullanici_field = new JTextField();
		assertNotNull(kullanici_field);
		JTextField sifree_field = new JTextField();
		assertNotNull(sifree_field);
		JButton btnNewButton = new JButton();
		assertNotNull(btnNewButton);
		
		
	}

}
