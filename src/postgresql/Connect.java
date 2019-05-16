package postgresql;

import java.sql.*;

public class Connect {
	
	
	//Used the Singleton design pattern here. 

	private static Connect instance = null;

	Connect() {
	}

	public static Connect getInstance() {
		if (instance == null) {
			synchronized (Connect.class) {
				if (instance == null) {
					instance = new Connect();
				}
			}
		}
		return instance;
	}

	private String url = "jdbc:postgresql://localhost:5433/TiyatroBilet";
	private String user = "postgres";
	private String password = "Zeyni15!";
	private static Statement rs;

	public Connection connect() throws SQLException {

		return DriverManager.getConnection(url, user, password);// veri tabanýna ait host ve veritabaný adýný ve veritabanýna ulaþacak
		// olan kullanýcý adý ve þifresini tanýmlýyoruz
	}

	public void getMusteri() {

		String SQL = "SELECT * FROM musteri";

		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(SQL)) { //sorgu sonucu gelen verileri tutar
			displayMusteri(rs);
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
	}

	private void displayMusteri(ResultSet rs) throws SQLException {
		while (rs.next()) {
			System.out.println(rs.getString("m_id") + "\t" + rs.getString("m_ad") + "\t" + rs.getString("email") + "\t"
					+ rs.getString("m_sifre") + "\t" + rs.getString("m_telno"));
		}
	}

	public int updateMusteri(int m_id, String m_sifre) {
		String SQL = "UPDATE  musteri " + "SET m_sifre =? " + "WHERE m_id =?";
		int affectedrows = 0;

		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {

			pstmt.setString(1, m_sifre);
			pstmt.setInt(2, m_id);
			affectedrows = pstmt.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return affectedrows;
	}

	/**
	 * Delete koltuk by koltuk_id *
	 * 
	 * @param id
	 * @return
	 */

	public int deleteKoltuk(int koltuk_id) {
		String SQL = "DELETE FROM koltuk WHERE koltuk_id = ?";
		int affectedrows = 0;

		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {

			pstmt.setInt(1, koltuk_id);

			affectedrows = pstmt.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return affectedrows;
	}

	/***
	 * Select all koltuk
	 * 
	 * @return
	 */

	public int getKoltukCount() {
		String SQL = "SELECT count(*) FROM koltuk";
		int count = 0;

		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(SQL)) {
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return count;
	}

	public static void main(String[] args) {
		Connect db = new Connect();
		int koltukCount = db.getKoltukCount();
		System.out.println(String.format("%d koltuk bulundu.\n", koltukCount));
		db.getMusteri();
		db.updateMusteri(6, "1700");
		db.deleteKoltuk(1);

	}
}
