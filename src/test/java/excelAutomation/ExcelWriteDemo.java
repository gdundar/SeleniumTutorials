package excelAutomation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelWriteDemo {

    @Test
    public void writeExcel() throws Exception {
        String filePath = "/Users/yasinbekar/IdeaProjects/SeleniumTutorials/src/test/java/excelAutomation/resources/Countries.xlsx";
        FileInputStream in = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(in);
        Sheet worksheet = workbook.getSheetAt(0);

        Cell column = worksheet.getRow(0).createCell(2);
        column.setCellValue("Continent");
        Cell col1a = worksheet.getRow(1).createCell(2);
        col1a.setCellValue("North America");
        Cell col1b = worksheet.getRow(2).createCell(2);
        col1b.setCellValue("South America");

        Cell column3 = worksheet.getRow(0).createCell(3);
        column3.setCellValue("Cars");
        Cell col2 = worksheet.getRow(1).createCell(3);
        col2.setCellValue("Toyota");
        Cell col3 = worksheet.getRow(2).createCell(3);
        col3.setCellValue("Lexus");
        Cell col4 = worksheet.getRow(3).createCell(3);
        col4.setCellValue("Honda");

        FileOutputStream out = new FileOutputStream(filePath);
        workbook.write(out);

        out.close();
        in.close();
    }

}
