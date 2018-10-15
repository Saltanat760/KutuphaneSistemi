package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import entity.Kitap;

public class KitapMapper implements RowMapper<Kitap>{

	@Override
	public Kitap mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return new Kitap(rs.getString("TITLE"),rs.getString("WRITER_NAME"),rs.getFloat("RENT_FEE"),rs.getInt("ISRENTABLE"));
	}

}
