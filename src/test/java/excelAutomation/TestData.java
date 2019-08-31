package excelAutomation;

import java.util.ArrayList;

public class TestData {

    public static void main(String[] args) throws Exception {

        DataDriven dd = new DataDriven();
        ArrayList data = dd.getData("Add Profile");
        System.out.println(data.get(0));
        System.out.println(data.get(1));
        System.out.println(data.get(2));
        System.out.println(data.get(3));

    }
}
