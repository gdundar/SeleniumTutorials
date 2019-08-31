package excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class ExcelReadDemo1 {

    @Test
    public void readXLFile() throws Exception {
        String path = "src/test/java/excelAutomation/resources/NamesAndCities.xls";
        FileInputStream inputStream = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet worksheet = workbook.getSheetAt(0);
        Row row = worksheet.getRow(0);
        Cell cell = row.getCell(0);
        System.out.println(cell);

        String name = worksheet.getRow(1).getCell(0).toString();
        //toString() and getStringCellValue() are almost same but different methods
        String cities = worksheet.getRow(1).getCell(1).getStringCellValue();
        System.out.println(name + " - " + cities);

        int rowsCount = worksheet.getLastRowNum(); //How to find col numbers?
        System.out.println(rowsCount);

        for(int i=1; i <= rowsCount; i++){
            System.out.println(i + " - " + worksheet.getRow(i).getCell(0).toString() +
                    " - " + worksheet.getRow(i).getCell(1));
        }

        Map<String, String> namesAndCities = new HashMap<>();
        for(int rowNum=1; rowNum <= rowsCount; rowNum++){
            String names = worksheet.getRow(rowNum).getCell(0).toString();
            String city = worksheet.getRow(rowNum).getCell(1).toString();
            namesAndCities.put(names, city);
        }
        System.out.println(namesAndCities);

        workbook.close();
        inputStream.close();
    }








}
