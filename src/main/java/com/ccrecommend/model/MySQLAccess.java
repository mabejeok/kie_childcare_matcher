package com.ccrecommend.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySQLAccess {
	// This class is in charge of getting results from MySQL
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    @SuppressWarnings("serial")
	private List<Map<String, String>> createChildcareDict(ResultSet resultSet) throws SQLException{
    	List<Map<String, String>> ccList = new ArrayList<Map<String, String>>();
    	while (resultSet.next()) {
	    	Map<String, String> myMap = new HashMap<String, String>() {{
		        put("centre_code", resultSet.getString("centre_code"));
		        put("centre_name", resultSet.getString("centre_name"));
		        put("centre_address", resultSet.getString("centre_address"));
		        put("postal_code", resultSet.getString("postal_code"));
		        put("infant_vacancy", resultSet.getString("infant_vacancy"));
		        put("pg_vacancy", resultSet.getString("pg_vacancy"));
		        put("n1_vacancy", resultSet.getString("n1_vacancy"));
		        put("n2_vacancy", resultSet.getString("n2_vacancy"));
		        put("k1_vacancy", resultSet.getString("k1_vacancy"));
		        put("k2_vacancy", resultSet.getString("k2_vacancy"));
		        put("food_offered", resultSet.getString("food_offered"));
		        put("second_language", resultSet.getString("second_language"));
		    }};
		    ccList.add(myMap);
	    }
    	return ccList;
	
    }
    
    public List<Map<String, String>> readChildcares(List<String> serviceCentreCodeList) throws Exception{
    	try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/cc_schema?"
                            + "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&user=root&password=MyNewPass");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            String serviceStr = String.join("', '", serviceCentreCodeList);
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("select * from cc_schema.childcares where centre_code in ('" + serviceStr + "')");
            return createChildcareDict(resultSet);

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }
    
    public List<Map<String, String>> readServices() throws Exception{
    	try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/cc_schema?"
                            + "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&user=root&password=MyNewPass");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("SELECT * FROM cc_schema.childcare_services");
            return createServiceDict(resultSet);

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }
    
    @SuppressWarnings("serial")
	private List<Map<String, String>> createServiceDict(ResultSet resultSet) throws SQLException{
    	List<Map<String, String>> serviceList = new ArrayList<Map<String, String>>();
    	while (resultSet.next()) {
	    	Map<String, String> myMap = new HashMap<String, String>() {{
		        put("centre_code", resultSet.getString("centre_code"));
		        put("centre_name", resultSet.getString("centre_name"));
		        put("type_of_service", resultSet.getString("type_of_service"));
		        put("level", resultSet.getString("level").substring(0, resultSet.getString("level").indexOf("(")).trim());
		        put("fee", resultSet.getString("fee"));
		        put("citizenship", resultSet.getString("citizenship").replace("\r", ""));
		    }};
		    serviceList.add(myMap);
	    }
    	return serviceList;
	
    }

    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}

