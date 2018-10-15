package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import entity.Kitap;

@Component("kitapDAO")
public class KitapDAO {
	private DataSource dataSource;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private List<Kitap> kitapListesi;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public void kitapEkle(Kitap kitap) {
		//System.out.println(kitap);
		String kitapSaySql = "SELECT * FROM BOOK";
		int kitapSay = namedParameterJdbcTemplate.query(kitapSaySql, new KitapMapper()).size();   // veritabanýnda id kýsmý otomatik artacak þekilde ayarlanmalý, bu sorgu gereksiz

		Map<String, Object> params = new HashMap<>();
		params.put("BOOK_ID", kitapSay+1);
		params.put("TITLE", kitap.getKitapAdi());
		params.put("WRITER_NAME", kitap.getYazarAdi());
		params.put("ISRENTABLE", kitap.getKiralanabilirMi());
		params.put("RENT_FEE", kitap.getKiralamaUcreti());
		
		String kitapEkleSql = "INSERT INTO BOOK(BOOK_ID,TITLE,WRITER_NAME,ISRENTABLE,RENT_FEE) VALUES(:BOOK_ID,:TITLE,:WRITER_NAME,:ISRENTABLE,:RENT_FEE)";
		namedParameterJdbcTemplate.update(kitapEkleSql , params);
	}

	public List<Kitap> getKitapListesi() {
		String kitaplarSql = "SELECT * FROM BOOK";
		kitapListesi = namedParameterJdbcTemplate.query(kitaplarSql, new KitapMapper());   // veritabanýnda id kýsmý otomatik artacak þekilde ayarlanmalý, bu sorgu gereksiz

		
		return kitapListesi;
	}
	
}
