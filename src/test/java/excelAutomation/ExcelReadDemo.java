package excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelReadDemo {

    @Test
    public void readXLFile()throws Exception{
        String path = "/Users/yasinbekar/IdeaProjects/SeleniumTutorials/src/test/java/excelAutomation/resources/Countries.xlsx";
        FileInputStream inputStream = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet worksheet = workbook.getSheetAt(0);

        Row row = worksheet.getRow(0);

        Cell cell1 = row.getCell(0);
        Cell cell2 = row.getCell(1);

        System.out.println(cell1.toString());
        System.out.println(cell2.toString());

        String country1 = worksheet.getRow(1).getCell(0).toString();
        String capital1 = worksheet.getRow(1).getCell(1).toString();
        //String capital1 = workbook.getSheetAt(0).getRow(1).getCell(1).toString();
        System.out.println(capital1 + " " + country1);

        int rowsCount =worksheet.getLastRowNum();
        System.out.println(rowsCount + " is the count of rows");

        for(int i =1; i<= rowsCount; i++){
            System.out.println("Country number " + i + " " + worksheet.getRow(i).getCell(0).toString() +
                                " \n Capital " + worksheet.getRow(i).getCell(1));
        }

        Map<String, String> countriesMap = new HashMap<>();
        for(int rowNum =1; rowNum <= rowsCount; rowNum++){
            String country = worksheet.getRow(rowNum).getCell(0).toString();
            String capital = worksheet.getRow(rowNum).getCell(1).toString();
            countriesMap.put(country, capital);
        }
        System.out.println(countriesMap);

        workbook.close();
        inputStream.close();
    }

}
