package postgresql;

public class Admin implements Kayit {
	
	private String Kullanici_adi;
	private int sifre;
	
	
	public Admin(String Kullanici_adi,int sifre){
		
		this.Kullanici_adi=Kullanici_adi;
		this.sifre=sifre;
		
		
	}


	@Override
	public void gosterkayitdetayi() {
		// TODO Auto-generated method stub
		
		System.out.println(Kullanici_adi+" "+sifre);
	}
	

	
	
	
	

}
