package com.infor.controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;



public class DBBookDao {
private JdbcTemplate jdbcTemplate;
	
	public DBBookDao(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void save(DBBook dbbook) {
		// TODO Auto-generated method stub
		System.out.println("implementing");
		
		if(dbbook.getId() > 0){
			
			String sql = "UPDATE dbBook name=?, auth=? WHERE contact_id=?";
			
			Object[] params = {dbbook.getName(), dbbook.getAuth(), dbbook.getId()};
			
			jdbcTemplate.update(sql, params);
		} else{
			
			
			String sql = "INSERT INTO dbbook (name, auth) VALUES(?, ?)";
			
			Object[] params = {dbbook.getName(), dbbook.getAuth(), dbbook.getId()};
			
			jdbcTemplate.update(sql, params);
		}
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		System.out.println("implementing");
		
		String sql = "DELETE from dbbook where id=?";
		Object[] cid = {id};
		jdbcTemplate.update(sql, cid);
	}

	public DBBook get(int id) {
		// TODO Auto-generated method stub
		System.out.println("implementing");
		
		String sql = "Select * from contact where id =" + id;
		return (DBBook) jdbcTemplate.query(sql, new ResultSetExtractor() {
			
			public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				if(rs.next()){
					DBBook c = new DBBook();
					c.setId(rs.getInt("id"));
					c.setName(rs.getString("name"));
					c.setAuth(rs.getString("Auth"));
					return c;
				}
				
				return 0;
			}
		});
		
	}

	public List<DBBook> list() {
		// TODO Auto-generated method stub
		System.out.println("implementing");
		
		String sql = "Select * from DBBook";
		List<DBBook> listdbbook = jdbcTemplate.query(sql, new RowMapper() {
			
			public DBBook mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				DBBook c = new DBBook();
				c.setId(rs.getInt("if"));
				c.setName(rs.getString("name"));
				c.setAuth(rs.getString("Auth"));
				return c;
			}
		});
		return listdbbook;
	}
}
