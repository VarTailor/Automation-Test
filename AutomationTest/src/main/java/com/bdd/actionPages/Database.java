package com.bdd.actionPages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.openqa.selenium.WebDriver;

public class Database extends BaseClass {
    public static WebDriver driver;

    public void dbTest() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
        Connection con = DriverManager.getConnection("jdbc:sqlserver://server:port;databaseName=db");
        Statement stmt = con.createStatement()	;
        ResultSet rs = stmt.executeQuery("select * from table");

        while (rs.next()) {
            rs.getString("colName");
        }
    }
}
