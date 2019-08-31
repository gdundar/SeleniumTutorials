package excel_data_driven;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelReadDemo {

    //to create on object that will store excel file
    Workbook workbook;//interface
    //to create an object that will store specific sheet
    Sheet sheet;
    //to provide path to the file
    String path = "src/test/resources/Countries.xlsx";
    //to establish connection with excel file
    FileInputStream inputStream;

    @BeforeMethod
    public void setUp() throws IOException {
        inputStream = new FileInputStream(path);
        workbook = WorkbookFactory.create(inputStream);
        //MUST be sheet name - find it on the left bottom on excel
        sheet = workbook.getSheet("Countries");
    }

    @Test
    public void readExcelFileRowAndColTest() {
        int rowCount = sheet.getLastRowNum();
        System.out.println(rowCount);

        int colCount = sheet.getRow(0).getLastCellNum();
        System.out.println(colCount);
    }
    @Test
    public void readSingleCellValueTest(){
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        String value = cell.getStringCellValue();
        System.out.println(value);

        String expected = "Nur-Sultan";
        String actual = sheet.getRow(2).getCell(1).toString();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void readWholeSheetTest(){
        int rowCount = sheet.getLastRowNum();
        for(int i=0; i <= rowCount; i++){
            String country = sheet.getRow(i).getCell(0). getStringCellValue();
            String capital = sheet.getRow(i).getCell(1).getStringCellValue();
            System.out.println(country+ " " + capital);
        }
    }

    @Test
    public void putDataIntoMapTets() {
        Map<String, String> countries = new HashMap<>();
        int rowCount = sheet.getLastRowNum();
        for (int i = 0; i <= rowCount; i++) {
            String country = sheet.getRow(i).getCell(0).getStringCellValue();
            String capital = sheet.getRow(i).getCell(1).getStringCellValue();
            countries.put(country, capital);
        }
        System.out.println(countries);
        String expected = "Mascow";
        String actual = countries.get("Russia");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void putDataIntoListOfMapsTest() {
        List<Map<String, String>> countries = new ArrayList<>();
        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();
        for (int j = 0; j < colCount; j++) {
            for (int i = 0; i <= rowCount; i++) {
                Map<String, String> map = new HashMap<>();
                String country = sheet.getRow(j).getCell(0).toString();
                String capital = sheet.getRow(j).getCell(1).toString();
                map.put("country", country);
                map.put("capital", capital);
                countries.add(map);
            }
        }
        System.out.println(countries);
    }

    @AfterMethod
    public void tearDown() throws IOException {
        workbook.close();
        inputStream.close();
    }

}
