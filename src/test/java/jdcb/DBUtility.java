package jdcb;

import selenium.utilities.ConfigurationReader;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtility {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static int rowsCount;

    public static void establishConnection(DBType dbType) throws SQLException {
        switch (dbType) {
            case ORACLE:
                connection = DriverManager.getConnection(ConfigurationReader.getProperty("oracledburl"),
                        ConfigurationReader.getProperty("oracledbusername"),
                        ConfigurationReader.getProperty("oracledbpassword"));
                break;
            default:
                connection = null;
                //return;
        }
    }

    public static int getRowsCount(String sql) throws SQLException {
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        resultSet = statement.executeQuery(sql);
        resultSet.last();
        return resultSet.getRow();
    }

    public static List<Map<String, Object>> runSQLQuery(String sql) throws SQLException {
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        resultSet = statement.executeQuery(sql);

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
        return list;
    }

    public static void closeConnections(){
      try {
          if (resultSet != null) {
              resultSet.close();
          }
          if (statement != null) {
              statement.close();
          }
          if (connection != null) {
              connection.close();
          }
      }catch (Exception e){
          e.printStackTrace();
        }
    }


}
