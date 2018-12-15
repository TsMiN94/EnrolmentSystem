package kr.ac.hansung.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import kr.ac.hansung.dao.EnrolmentDAO;
import kr.ac.hansung.dao.SubjectDAO;
import kr.ac.hansung.model.Subject;

public class EnrolmentService {
	@Autowired
	private EnrolmentDAO enrolmentDAO;
	
	public void insert(Subject subject) {
		enrolmentDAO.insert(subject);
	}

	public List<Subject> getSubjects(int year, int semester) {
		return enrolmentDAO.getSubjects(year, semester);
	}

	

}
