package jdcb;

import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class EmployeesDbTest {

    @Test
    public void countTest() throws SQLException {
        DBUtility.establishConnection(DBType.ORACLE);
        int rowsCount = DBUtility.getRowsCount("select * from employees where job_id = 'IT_PROG'");
        System.out.println(rowsCount);
        assertTrue(rowsCount > 0);
        DBUtility.closeConnections();
    }

    @Test
    public void nameTestByID()throws SQLException{
        DBUtility.establishConnection(DBType.ORACLE) ;
        List<Map<String, Object>> employeeData = DBUtility.runSQLQuery("select first_name, last_name FROM employees where employee_id=105");

        assertEquals(employeeData.get(0).get("FIRST_NAME"), "David");
        assertEquals(employeeData.get(0).get("LAST_NAME"), "Austin");

        //was thinking looping and printing all names + last names
        int rowsCount = DBUtility.getRowsCount("Select distinct job_id from employees");
        System.out.println(rowsCount);

        System.out.println(employeeData.get(0).get("FIRST_NAME"));
        System.out.println(employeeData.get(0).get("LAST_NAME"));
        for(Map<String, Object> emp : employeeData){
            System.out.println(emp.get("FIRST_NAME"));
            System.out.println(emp.get("LAST_NAME"));
        }
        DBUtility.closeConnections();
    }

}
