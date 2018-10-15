package dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import entity.User;

@Component("userDAO")
public class UserDAO {
	private DataSource dataSource;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public void create(User user) {
		System.out.println(user);
		Map<String, Object> params = new HashMap<>();
		params.put("USERNAME", user.getUsername());
		params.put("NAME", user.getName());
		params.put("SURNAME", user.getSurname());
		params.put("EMAIL", user.getEmail());
		params.put("PASSWORD", user.getPassword());
		params.put("ENABLED", user.getEnabled());
		params.put("AUTHORITY", user.getAuthority());
		
		namedParameterJdbcTemplate.update("insert into USERS(USERNAME, NAME,SURNAME,EMAIL,PASSWORD, ENABLED) VALUES(:USERNAME, :NAME, :SURNAME, :EMAIL, :PASSWORD, :ENABLED)", params);
		namedParameterJdbcTemplate.update("insert into AUTHORITIES(USERNAME, AUTHORITY) VALUES(:USERNAME, :AUTHORITY)",params );
	}
	
}
