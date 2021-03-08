import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ApachePOI {
    public static void main(String[] args) {
        /**
         * this is creation of the book object. Like container for all the sheets
         */
        XSSFWorkbook workbook = new XSSFWorkbook();
        /**
         * We are creating the sheet in that book. and we give a name to that sheet.
         */
        XSSFSheet sheet = workbook.createSheet("Java Books");
        /**
         * adding data to the sheet
         */
        Object[][] bookData = {
                {"Head First Java", "Kathy Serria", "79"},
                {"Effective Java", "Joshua Bloch", "36"},
                {"Clean Code", "Robert martin", "42"},
                {"Thinking in Java", "Bruce Eckel", "35"},
        };

        int rowCount = 0;

        for (Object[] aBook : bookData) {
            Row row = sheet.createRow(++rowCount);
            //var++ returns its value before incrementing.
            //result = var +1;
            //++var returns its value after incrementing.
            //var + 1 = result
            int columnCount = 0;

            for (Object field : aBook) {
                Cell cell = row.createCell(++columnCount);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }

        }

        try (FileOutputStream outputStream = new FileOutputStream("src/main/resources/JavaBooks.xlsx")) {
            try {
                workbook.write(outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}