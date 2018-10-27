package dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import entity.Kitap;
import entity.User;

@Component("userDAO")
public class UserDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	private String hataMesaji;
	

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
    private IAuthenticationFacade authenticationFacade; 
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void create(User user) {
		setHataMesaji("");
		try {
			System.out.println("1111111111"); 
			jdbcTemplate.update("insert into USERS VALUES(?, ?, ?, ?, ?, ?)", 
					new Object[] {user.getUsername(),user.getName(), user.getEnabled(), passwordEncoder.encode(user.getPassword()), user.getSurname(), user.getEmail()});
			jdbcTemplate.update("insert into AUTHORITIES VALUES(?, ?)",new Object[] {user.getUsername(),user.getAuthority()});
			
		} catch (Exception e) {
			setHataMesaji(e.toString());
		}
	}

	public void kiraladigimKitaplaraEkle(String[] gelenKitapIDler) {
		// kiralanan kitaplar tablosuna ekleme yapýlacak
		setHataMesaji("");
		
		try {
			String kullaniciAdi = authenticationFacade.getAuthentication().getName();
			System.out.println("kullanýcý adý : "+kullaniciAdi);
			for (String id : gelenKitapIDler) {
				System.out.println("id : "+id);
				jdbcTemplate.update("insert into RENTED_BOOKS(USERNAME, BOOK_ID) VALUES(?, ?)",new Object[] {kullaniciAdi,Integer.parseInt(id)} );			
			}
		} catch (Exception e) {
			setHataMesaji(e.toString());
		}
	}

	public List<Kitap> getKitaplarim() {
		// TODO Auto-generated method stub		
		setHataMesaji("");
		List<Kitap> kiraladigimKitapListesi = null;
		try {
			String kullaniciAdi = authenticationFacade.getAuthentication().getName();
			String kitaplarSql = "SELECT * FROM VW_RENTED_BOOKS_DETAILS WHERE USERNAME='"+kullaniciAdi+"'";
			kiraladigimKitapListesi = jdbcTemplate.query(kitaplarSql, new KitapMapper());   
			
			return kiraladigimKitapListesi;
		} catch (Exception e) {
			setHataMesaji(e.toString());
		}
		
		return kiraladigimKitapListesi;
	}

	public void odemeYapilacakKitaplar(String[] odenecekKitapIDler) {
		// TODO Auto-generated method stub
		
		//String kullaniciAdi = authenticationFacade.getAuthentication().getName();
		setHataMesaji("");

		String sql="";
		
		try {
			for (String id : odenecekKitapIDler) {
				sql = "DELETE FROM RENTED_BOOKS WHERE BOOK_ID = ";
				sql = sql+id;
				jdbcTemplate.update(sql);			
			}
		} catch (Exception e) {
			setHataMesaji(e.toString());
		}
	}

	public List<Map<String, Object>> getKiralananKitaplar() {
		// TODO Auto-generated method stub
		
		String kitaplarSql = "SELECT * FROM VW_RENTED_BOOKS_DETAILS";
		List<Map<String, Object>> kiralananKitapListesi = null;
		
		try {
			kiralananKitapListesi = jdbcTemplate.queryForList(kitaplarSql);   
				
			for (Map<String, Object> map : kiralananKitapListesi) {
				System.out.println(map);
			}

			return kiralananKitapListesi;
		} catch (Exception e) {
			setHataMesaji(e.toString());
		}

		return kiralananKitapListesi;
	}
	

	public String getHataMesaji() {
		return hataMesaji;
	}

	public void setHataMesaji(String hataMesaji) {
		this.hataMesaji = hataMesaji;
	}
	
}
