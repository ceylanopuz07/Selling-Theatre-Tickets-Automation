package postgresql;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConnectTest {

	@Test
	public void test() {
		int koltukCount=Connect.getInstance().getKoltukCount() ;
		Connect.getInstance().getKoltukCount(); 
		System.out.println(String.format("%d koltuk bulundu.\n",koltukCount));
		Connect.getInstance().getMusteri();
		Connect.getInstance().updateMusteri(6, "700");
		Connect.getInstance().deleteKoltuk(1);
		
		
		
	}

}
