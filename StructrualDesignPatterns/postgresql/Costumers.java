package postgresql;

public class Costumers implements Kayit {
	private String m_ad�;
	private String m_sifre;
	private String email;
	private int telno;
	
	
	public Costumers(String m_ad�,String email,String m_sifre,int telno){
		this.m_ad�=m_ad�;
		this.email=email;
		this.m_sifre=m_sifre;
		this.telno=telno;
		
		
	}


	@Override
	public void gosterkayitdetayi() {
		// TODO Auto-generated method stub
		System.out.println(m_ad�+" "+email+" "+m_sifre+" "+telno);
		
		
	}
	
	

}
