package postgresql;

import static org.junit.Assert.*;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.junit.Test;

public class BiletlerimTest {

	@Test
	public void test() {
		JPanel contentPane = new JPanel();
		assertNotNull(contentPane);
		JScrollPane scrollPane = new JScrollPane();
		assertNotNull(scrollPane);
		JTable table = new JTable();
		assertNotNull(table);
		JTextField m_id = new JTextField();
		assertNotNull(m_id);
	}

}
