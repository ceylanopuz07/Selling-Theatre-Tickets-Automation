package postgresql;

import static org.junit.Assert.*;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.junit.Test;

public class MusteriBilgieriTest {

	@Test
	public void test() {
		Connect.getInstance();
		JPanel contentPane = new JPanel();
		assertNotNull(contentPane);
		JTable table = new JTable();
		assertNotNull(table);
		JButton giris_field = new JButton("Giri\u015F");
		assertNotNull(giris_field);
		JTextField m_id = new JTextField();
		assertNotNull(m_id);
	}
}
