package postgresql;

import java.util.ArrayList;
import java.util.List;

public class Kontrol implements Kayit {

	private List<Kayit> KayitList = new ArrayList<Kayit>();

	@Override
	public void gosterkayitdetayi() {
		// TODO Auto-generated method stub

		for (Kayit kyt : KayitList) {
			kyt.gosterkayitdetayi();
		}

	}
	public void addKayit(Kayit kyt){
		KayitList.add(kyt);
		
	}
	public void remove(Kayit kyt){
		KayitList.remove(kyt);
	}

}
