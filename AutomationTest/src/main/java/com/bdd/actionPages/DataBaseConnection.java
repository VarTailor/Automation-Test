package com.bdd.actionPages;

import java.sql.*;

public class DataBaseConnection {

    public void connectToDB() throws SQLException {
        Connection connection= DriverManager.getConnection("jdbc:mysql","userName", "password");
        Statement statement=connection.createStatement();
        String query="Select * From tableName where condition <someCondition>";
        ResultSet rs=statement.executeQuery(query);
        while ((rs.next())){
            String colValue1= rs.getString("colName1");
            String colValue2= rs.getString("colName2");
        }

    }
}
