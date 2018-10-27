package dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate; 
import org.springframework.stereotype.Component;

import entity.Kitap;

@Component("kitapDAO")
public class KitapDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private List<Kitap> kitapListesi;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void kitapEkle(Kitap kitap) {
		//System.out.println("kitap ekleme 1");
		String kitapEkleSql = "INSERT INTO BOOK VALUES(Book_SEQ.NEXTVAL,?,?,?,?)";
		jdbcTemplate.update(kitapEkleSql , new Object[] {kitap.getKitapAdi(),kitap.getYazarAdi(), kitap.getKiralanabilirMi(), kitap.getKiralamaUcreti()}  );
		//System.out.println("kitap ekleme 2");
	}

	public List<Kitap> getKitapListesi() {
		String kitaplarSql = "SELECT * FROM BOOK";
		kitapListesi = jdbcTemplate.query(kitaplarSql, new KitapMapper());   

		
		return kitapListesi;
	}

	public void kiralananGuncelle(String[] gelenKitapIDler, int kiralama) {
		// kitap tablosundaki kitaplarýn kiralanabilir mi alaný 0 lanacak

		String sql="";
		
		for (String id : gelenKitapIDler) {
			sql = "UPDATE BOOK SET ISRENTABLE = " + kiralama + "WHERE BOOK_ID=";
			sql = sql+id;
			jdbcTemplate.update(sql);			
		}
	}
	
}
