package com.bdd.actionPages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Database extends BaseClass {
	public static WebDriver driver;

	public static final String URL = "jdbc:mysql://localhost:3306/your_database_name";
	public static final String USERNAME = "your_username";
	public static final String PASSWORD = "your_password";

	@Test
	public void Test_API() throws Exception {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		String sqlQuery = "SELECT * FROM your_table_name";
		preparedStatement = connection.prepareStatement(sqlQuery);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			// Retrieve data from the ResultSet
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			System.out.println("ID: " + id + ", Name: " + name);

		}
	}

}
