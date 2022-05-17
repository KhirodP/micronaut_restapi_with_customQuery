package com.khirod.controller;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import com.khirod.entity.Student;
import com.khirod.service.Service;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;

@Controller
public class MyController {
	
	@Inject
	private Service service;
	
	@Get("/displayMsg")
	public String displayMsg()
	{
		return "welcome to micronaut";
	}
	
	@Get("/student")
	 public List<Student> getStudent() throws ClassNotFoundException, SQLException
	{
		return this.service.getStudent();
	}
	
	@Get("/student/{studentid")
	public Student getStudent(@PathVariable String studentid ) throws NumberFormatException, ClassNotFoundException, SQLException
	{
		return this.service.getStudent(Integer.parseInt(studentid));
		
	}
	@Put
	public Student updateStudent(@Body Student student)
	{
		return this.service.updateStudent(student);
		
	}
	@Post("/student")
	public Student addStudent(@Body Student student) throws ClassNotFoundException, SQLException
	{
		return this.service.addStudent(student);
	}
}
