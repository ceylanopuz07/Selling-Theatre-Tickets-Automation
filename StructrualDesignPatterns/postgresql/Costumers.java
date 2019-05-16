package postgresql;

public class Costumers implements Kayit {
	private String m_adý;
	private String m_sifre;
	private String email;
	private int telno;
	
	
	public Costumers(String m_adý,String email,String m_sifre,int telno){
		this.m_adý=m_adý;
		this.email=email;
		this.m_sifre=m_sifre;
		this.telno=telno;
		
		
	}


	@Override
	public void gosterkayitdetayi() {
		// TODO Auto-generated method stub
		System.out.println(m_adý+" "+email+" "+m_sifre+" "+telno);
		
		
	}
	
	

}
