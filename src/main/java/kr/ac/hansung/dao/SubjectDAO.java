package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Subject;

@Repository
public class SubjectDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
	public List<Subject> getSubjectBySemester() {
		String sqlStatement = "select year, semester, sum(grade) from mtssubject group by year, semester";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Subject>() {
			
			@Override
			public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Subject subject = new Subject();
				subject.setGrade(rs.getInt("sum(grade)"));
				subject.setSemester(rs.getInt("semester"));
				subject.setYear((rs.getInt("year")));
				
				return subject;
			}
		});
	}
	
	public List<Subject> getSubjectBySelect(int year) {
		String sqlStatement = "select * from mtssubject where year=?";
		return jdbcTemplate.query(sqlStatement, new Object[] { year }, new RowMapper<Subject>() {
			
			//receive record  ->  set Object  ->  return object
			@Override
			public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Subject subject = new Subject();
				subject.setId(rs.getInt("id"));
				subject.setGrade(rs.getInt("grade"));
				subject.setSemester(rs.getInt("semester"));
				subject.setSubjectCode(rs.getString("subjectCode"));
				subject.setSubjectName(rs.getString("subjectName"));
				subject.setType(rs.getString("subjectType"));
				subject.setYear((rs.getInt("year")));
				
				return subject;
			}
		});
	}
	// query and return a multiple object
		public List<Subject> getSubjects(int year, int semester) {
			String sqlStatement = "select * from mtssubject where year=? and semester=?";
			return jdbcTemplate.query(sqlStatement, new Object[] { year, semester }, new RowMapper<Subject>() {
				
				//receive record  ->  set Object  ->  return object
				@Override
				public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					Subject subject = new Subject();
					subject.setId(rs.getInt("id"));
					subject.setGrade(rs.getInt("grade"));
					subject.setSemester(rs.getInt("semester"));
					subject.setSubjectCode(rs.getString("subjectCode"));
					subject.setSubjectName(rs.getString("subjectName"));
					subject.setType(rs.getString("subjectType"));
					subject.setYear((rs.getInt("year")));
					
					return subject;
				}
			});
		}

	public boolean insert(Subject subject) {
		int year = subject.getYear();
		int semester = subject.getSemester();
		String subjectCode = subject.getSubjectCode();
		String subjectName = subject.getSubjectName();
		String subjectType = subject.getType();
		int grade = subject.getGrade();
		
		String query = "insert into mtssubject (year,semester,subjectCode,subjectName,subjectType,grade) values (?,?,?,?,?,?) ";
		return (jdbcTemplate.update(query, new Object[] { year, semester, subjectCode ,subjectName,subjectType,grade}) == 1);

	}


}
