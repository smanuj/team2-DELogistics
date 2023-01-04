package com.valtech.team18.dao;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;





@Component
public class UserDaoImpl implements UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	@Override
	public void deleteSupplierRegistration(int id) {
		String sql = "delete Users where id = ?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public void deleteTruckDriverRegistration(int id) {
		String sql = "delete Users where id = ?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public void changePass(String password, int userId) throws Exception {
		System.out.println(userId + password);
		logger.info("updating pass");
		String sql = "update Users set password = ? where id = ?";
		jdbcTemplate.update(sql, password, userId);
		logger.debug("password updated for id = " + userId);
	}

}
