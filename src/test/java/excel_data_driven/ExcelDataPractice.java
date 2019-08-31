package excel_data_driven;

import com.github.javafaker.Faker;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import org.apache.poi.ss.usermodel.*;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class ExcelDataPractice {
    Workbook workbook;
    Sheet sheet;
    String path = "src/test/java/excel_data_driven/gradebook.xls";
    FileInputStream inputStream;
    FileOutputStream fileOutputStream;

    int rowCount;
    int colCount;

    @BeforeMethod
    public void  setUp() throws  Exception{
        inputStream = new FileInputStream(path);
        workbook = WorkbookFactory.create(inputStream);
        fileOutputStream = new FileOutputStream(path);
        sheet = workbook.getSheet("Sheet1");
    }

    @Test
    public void rowsAndCols(){
        rowCount = sheet.getLastRowNum();
        colCount = sheet.getRow(0).getLastCellNum();
        System.out.println(rowCount + " - " + colCount);
    }

    @Test
    public void readingCell() {
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        System.out.println(cell.toString());
        System.out.println(cell.getStringCellValue());
    }

    @Test
    public void putDataIntoMap(){
        Map<String, String> gradeBook = new TreeMap<>();
        rowCount = sheet.getLastRowNum();
        for(int i=1; i <=rowCount; i++) {
                String names = sheet.getRow(i).getCell(0).getStringCellValue();
                String lastName = sheet.getRow(i).getCell(1).getStringCellValue();
                gradeBook.put(names, lastName);
            }
        System.out.println(gradeBook);
    }

    @Test
    public void putDataIntoListOfMap(){
        List<Map<String, String>> gradeBook = new ArrayList<>();
        rowCount = sheet.getLastRowNum();
        colCount = sheet.getRow(0).getLastCellNum();
        for(int i=1; i<colCount; i++){
            for(int j=1; j<=rowCount; j++){
                Map<String, String> map = new TreeMap<>();
                String names = sheet.getRow(j).getCell(0).toString();
                String lastName = sheet.getRow(j).getCell(1).toString();
                //map.put("First Name", names);
                //map.put("Last Name", lastName);
                gradeBook.add(map);
                map.put(names, lastName);
            }
        }
        System.out.println(gradeBook);
    }

    @Test
    public void writeDataTest(){
        Cell columnName = sheet.getRow(0).getCell(2);
        if(columnName == null){
            //to create a cell
            columnName = sheet.getRow(0).createCell(2);
        }
        //3rd column is completely empty
        //we will write down test result next to every data set
        columnName.setCellValue("Pass / Fail"); // to write something into cell
        int rowCount = sheet.getLastRowNum();
        for(int row =1; row<=rowCount; row++){
            Row rowValue = sheet.getRow(row);
            Cell cell = rowValue.getCell(2);
            if(cell==null){
                cell = rowValue.createCell(2);
            }
            if(row % 2 == 0){
                cell.setCellValue("PASS");
            }else{
                cell.setCellValue("FAIL");
            }
        }
    }


    @AfterMethod
    public void tearDown() throws IOException {
        workbook.write(fileOutputStream);
        workbook.close();
        inputStream.close();
    }

/*
    public static void main(String[] args) {
        Faker faker = new Faker();

        String streetName = faker.address().streetName();
        String number = faker.address().buildingNumber();
        String city = faker.address().city();
        String streetName2 = faker.address().streetName();
        String number2 = faker.address().buildingNumber();
        String city2 = faker.address().city();
        String streetName3 = faker.address().streetName();
        String number3 = faker.address().buildingNumber();
        String city3 = faker.address().city();
        String streetName4 = faker.address().streetName();
        String number4 = faker.address().buildingNumber();
        String city4 = faker.address().city();

        System.out.println(
                number + "\n"+ streetName + "\n"+ city + "\n"+ number2+ "\n"+ streetName2 + "\n"+ city2+ "\n"+ number3 + "\n"+streetName3+ "\n"+ city3 + "\n"+ number4 + "\n"+ streetName4 + "\n"+ city4 );
    }
 */
}
