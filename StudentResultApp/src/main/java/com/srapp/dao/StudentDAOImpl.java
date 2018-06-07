package com.srapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.srapp.bo.StudentBO;
import com.srapp.command.StudentCommand;

@Repository
public class StudentDAOImpl implements StudentDAO {
	private static final String SELECT_QUERY = "SELECT * FROM sampledatabase.student where city=? and age  BETWEEN ? and ?";
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<StudentBO> getStudentsResults(StudentBO studentBO) {
		List<StudentBO> lsbo = jdbcTemplate.query(SELECT_QUERY, new StudentRowMapper(), studentBO.getCity(),
				studentBO.getLowerAge(), studentBO.getUpperAge());
		return lsbo;
	}

	private class StudentRowMapper implements RowMapper<StudentBO> {

		@Override
		public StudentBO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
				StudentBO bo = new StudentBO();
				bo.setId(rs.getInt(1));
				bo.setName(rs.getString(2));
				bo.setAge(rs.getInt(3));
				bo.setMarks(rs.getInt(4));
				bo.setCity(rs.getString(5));
			
				return bo;
			}
		
	}
}
