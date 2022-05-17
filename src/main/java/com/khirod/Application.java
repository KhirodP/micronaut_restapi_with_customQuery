package com.khirod;

import java.sql.SQLException;

import io.micronaut.runtime.Micronaut;

public class Application {

	public static void main(String[] args) throws Exception {
		Micronaut.run(Application.class, args);
		
		String DBname = "khirod";
		
		CheakAndCreate.createDB(DBname);
		System.out.println("application using micronaut...!!");
	}
}
