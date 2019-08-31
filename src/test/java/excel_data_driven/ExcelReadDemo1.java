package excel_data_driven;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelReadDemo1 {
    Workbook workbook;
    Sheet sheet;
    String path = "src/test/java/excelAutomation/resources/NamesAndCities.xls";
    FileInputStream inputStream;

    @BeforeMethod
    public void  setUp() throws  Exception{
        inputStream = new FileInputStream(path);
        workbook = WorkbookFactory.create(inputStream);
        sheet = workbook.getSheet("Sheet1");
    }

    @Test
    public void readExcelFileRowAndCol(){
        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();
        System.out.println(rowCount + " - " + colCount);
    }

    @Test
    public void readSingleCellValue(){
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        String  value = cell.getStringCellValue();
        System.out.println(value);

        String expected = "Ankara";
        String actual = sheet.getRow(2).getCell(1).toString();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void readWholeSheet(){
        int rowCount = sheet.getLastRowNum();
        for(int i=0; i<= rowCount; i++){
            String names = sheet.getRow(i).getCell(0).getStringCellValue();
            String cities = sheet.getRow(i).getCell(1).getStringCellValue();
            System.out.println(names + " - " + cities);
        }
    }

    @Test
    public void putDataIntoMap(){
        Map<String, String> namesAndCities = new HashMap<>();
        int rowCount = sheet.getLastRowNum();
        for(int i=0; i<= rowCount; i++){
            String names = sheet.getRow(i).getCell(0).getStringCellValue();
            String cities = sheet.getRow(i). getCell(1).getStringCellValue();
            namesAndCities.put(names, cities);
        }
        System.out.println(namesAndCities);

        String excpected = "New York";
        String actual = namesAndCities.get("Steve");
        Assert.assertEquals(actual, excpected);
    }

    @Test
    public void putDataIntoListOfMaps(){
        List<Map<String, String >> namesAndCities = new ArrayList<>();
        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();
        for(int i=0; i< rowCount; i++){
            for(int j=0; j<=colCount; j++){
                Map<String, String> map = new HashMap<>();
                String name = sheet.getRow(j).getCell(0).toString();
                String city = sheet.getRow(j).getCell(1).toString();
                map.put("Name", name);
                map.put("City", city);
                namesAndCities.add(map);
            }
        }
        System.out.println(namesAndCities);

    }

    @AfterMethod
    public void tearDwon() throws Exception{
        workbook.close();
        inputStream.close();
    }

}
