package jdcb;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCConnection {

    String oracledDUrl="jdbc:oracle:thin:@ec2-54-167-216-167.compute-1.amazonaws.com:1521:xe";
    String oracleDUserName="hr";
    String oracleDPassword="hr";

    @Test
    public void oracleJDBC() throws SQLException {
        Connection connection = DriverManager.getConnection(oracledDUrl, oracleDUserName, oracleDPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select * from countries");

        resultSet.next();
        System.out.println(resultSet.getString("country_name"));
        System.out.println(resultSet.getInt("region_id"));

        resultSet.beforeFirst(); // not to loose the first row!!!
        while(resultSet.next()) {
            System.out.println(resultSet.getString(1) +" - " + resultSet.getString("Country_name") + " - " + resultSet.getString("region_id"));
        }

        System.out.println(resultSet.getRow());

        resultSet.last();
        int rowsCount = resultSet.getRow();
        System.out.println(rowsCount + " is the rows count");

        resultSet.close();
        statement.close();
        connection.close();
    }

    @Test
    public void metaData() throws SQLException {
        Connection connection = DriverManager.getConnection(oracledDUrl, oracleDUserName, oracleDPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        String sql = "Select employee_id, last_name, job_id, salary from employees";
        //String sql = "Select * from employees";
        ResultSet resultSet = statement.executeQuery(sql);

        DatabaseMetaData dbMetadata = connection.getMetaData();
        System.out.println("User:" + dbMetadata.getUserName());
        System.out.println("Database type:" + dbMetadata.getDatabaseProductName());

        ResultSetMetaData rsMetadata = resultSet.getMetaData();
        System.out.println("Columns count:" + rsMetadata.getColumnCount());
        System.out.println(rsMetadata.getColumnName(1));

        for(int i=1; i<=rsMetadata.getColumnCount(); i++){
            System.out.println(i + " -> " + rsMetadata.getColumnName(i));
        }


        List<Map<String, Object>> list = new ArrayList<>();
        ResultSetMetaData rsMdata = resultSet.getMetaData();

        int colCount = rsMdata.getColumnCount();
        while(resultSet.next()){
            Map<String, Object> rowMap = new HashMap<>();
            for(int col = 1; col <= colCount; col++){
                rowMap.put(rsMdata.getColumnName(col), resultSet.getObject(col));
            }
            list.add(rowMap);
        }
        System.out.println(list);

        for(Map<String, Object> emp : list){
            System.out.println(emp.get("EMPLOYEE_ID"));
        }

        for(Map<String, Object> emp : list){
            System.out.println(emp.get("JOB_ID"));
        }

        resultSet.close();
        statement.close();
        connection.close();

    }



}


