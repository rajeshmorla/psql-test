package com.example.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping("/v1/table")
public class RestAPI 
{
	@RequestMapping(method = RequestMethod.GET) 
	public static String fetchTables() throws IOException, SQLException
	{
		List<String> tables = new ArrayList<String>();
		
		 String instanceConnectionName = "digisense222311:asia-south1:psql-dev-db";
		 String username = "postgres";
		 String password = "mJHkgFHBgoghLkwj";
		 String url = "jdbc:postgresql://35.244.6.127:5432/digisense-dev";
		 
		 Connection connection = DriverManager.getConnection(url, username, password);

		    try (Statement statement = connection.createStatement()) {
		      ResultSet resultSet =
		          statement.executeQuery(
		              "SELECT schemaname, tablename FROM pg_catalog.pg_tables");
		      while (resultSet.next()) {
		    	  
		    	  tables.add(resultSet.getString(1) + "." + resultSet.getString(2));
		      }
		    }
		
		    
		return new Gson().toJson(tables);
	}
	
	
	
	
	
	
	
}
