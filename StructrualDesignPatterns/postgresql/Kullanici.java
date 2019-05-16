package postgresql;

public class Kullanici {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Admin admn1 = new Admin("Hüseyin12", 552);
		Admin admn2 = new Admin("Cevdatboss", 152);
		Kontrol adminkyt = new Kontrol();
		adminkyt.addKayit(admn1);
		adminkyt.addKayit(admn2);
		Kayit cos1 = new Costumers("Ceylan", "Cey@gmail.com", "05343435203", 1222);
		Kayit cos2 = new Costumers("Hakan", "hakan@gmail.com", "05453535203", 1234);
		Kontrol cosKayit = new Kontrol();
		cosKayit.addKayit(cos1);
		cosKayit.addKayit(cos2);
		
		Kontrol kayitKontrol=new Kontrol();
		kayitKontrol.addKayit(adminkyt);
		kayitKontrol.addKayit(cosKayit);
		kayitKontrol.gosterkayitdetayi();
	} 

}
