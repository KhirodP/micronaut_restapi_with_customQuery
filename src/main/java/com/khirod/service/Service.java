package com.khirod.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.khirod.Constants;
import com.khirod.entity.Student;
import com.khirod.repository.Repository;

@Singleton
public class Service {
	
	@Inject
	private Constants connections;
	
	
	List<Student> list;
	
	public List <Student> getStudent() throws ClassNotFoundException, SQLException
	{
		Connection con = connections.getConnectoins();
		Statement stmt =con.createStatement();
		String FEATCH_DATA_STUDENTINFO = "SELECT * FROM STUDENT_INFO";

		ResultSet rs =  stmt.executeQuery(FEATCH_DATA_STUDENTINFO);
		
		ArrayList<Student> sl = new ArrayList<>();
		
		while(rs.next())
		{
			Student student = new Student(rs.getInt("Student_id"),rs.getString("name"),rs.getString("parent_name"),rs.getString("city"),rs.getLong("mobile_no"));
			
		}
		return sl;
		
	}
	
	public Student getStudent(int studentid) throws ClassNotFoundException, SQLException {
		
		Connection con = connections.getConnectoins();
		Statement stmt =con.createStatement();
		String FEATCH_DATA_STUDENTINFO_BYID = "select student_id,student_name,student_address from studentinfo where student_id = ";
		
		ResultSet rs= stmt.executeQuery(FEATCH_DATA_STUDENTINFO_BYID+studentid);
		
		Student student = new Student();
		while(rs.next())
		{

			student.setStudent_id(rs.getInt(1));
			student.setName(rs.getString(2));
			student.setParent_name(rs.getString(3));
			student.setCity(rs.getString(4));
			student.setMobile_no(rs.getLong(5));
		}
		

		return student;
		
	}

	public Student updateStudent(Student student) {
		
		return null;
	}

	public Student addStudent(Student student) throws ClassNotFoundException, SQLException {
		
		Connection con = connections.getConnectoins();
		PreparedStatement pstmt = con.prepareStatement("insert into student_info values(?,?,?,?,?)");
		pstmt.setInt(1,student.getStudent_id());
		pstmt.setString(2,student.getName());
		pstmt.setString(3,student.getParent_name());
		pstmt.setString(4,student.getCity());
		pstmt.setLong(5,student.getMobile_no());
		
		pstmt.execute();
		
		return student;
		
	}
	
}
