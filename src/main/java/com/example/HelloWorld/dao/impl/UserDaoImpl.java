package com.example.HelloWorld.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.example.HelloWorld.controllers.bean.User;
import com.example.HelloWorld.dao.UserDao;

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao{

	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}
	
	
	
	@Override
	public User getUserById(String userId) {
		String sql= "select * from register where email=?";
		
		return getJdbcTemplate().queryForObject(sql, new Object[] {userId},new RowMapper<User>() {
			
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException{
				User user =new User();
				user.setUserid(userId);
				user.setPassword(rs.getString(5));
				System.out.print("result"+rs);
				return user;
						
			}
		});
	}

		
		
	
}

