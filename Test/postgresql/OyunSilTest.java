package postgresql;

import static org.junit.Assert.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.junit.Test;

public class OyunSilTest {

	

	@Test
	public void test() {
		
		JPanel contentPane = new JPanel();
		assertNotNull(contentPane);
		JScrollPane scrollPane = new JScrollPane();
		assertNotNull(scrollPane);
		JButton btnNewButton = new JButton("OYUNU S\u0130L");
		assertNotNull(btnNewButton);
		JTextField idfield = new JTextField();
		assertNotNull(idfield);
		JLabel lblNewLabel_5 = new JLabel("OYUN ID");
		assertNotNull(lblNewLabel_5);
	}

}
