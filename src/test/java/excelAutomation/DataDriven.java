package excelAutomation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class DataDriven {

    public static ArrayList getData(String testCaseName) throws Exception{

        ArrayList<String > arrayList = new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream("/Users/yasinbekar/IdeaProjects/SeleniumTutorials/src/test/java/excelAutomation/resources/DataTest.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        int sheets = workbook.getNumberOfSheets();
        for(int i=0; i<sheets; i++){
            if(workbook.getSheetName(i).equalsIgnoreCase("Sheet2")){
                XSSFSheet sh = workbook.getSheetAt(i);
                Iterator<Row> rows = sh.iterator();
                Row firstRow = rows.next();
                Iterator<Cell> cell = firstRow.cellIterator();
                int k = 0;
                int column = 0;
                while ((cell.hasNext())){
                    Cell value = cell.next();
                    if(value.getStringCellValue().equalsIgnoreCase("Sheet2")){
                        column = k;
                    }
                    k++;
                    System.out.println(value);
                }
                System.out.println(column);

                while ((rows.hasNext())){
                    Row r = rows.next();
                    if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)){
                        Iterator<Cell> cv = r.cellIterator();
                        while(cv.hasNext()){
                            Cell c = cv.next();
                            if(c.getCellType()== CellType.STRING){
                                arrayList.add(c.getStringCellValue());
                            }else{
                                arrayList.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }


}
