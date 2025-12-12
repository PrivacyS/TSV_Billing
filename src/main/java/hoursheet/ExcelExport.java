package hoursheet;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
public class ExcelExport {
    public void createExcel() {
// 1. Create a Workbook (holds the entire Excel file)
        // Use XSSFWorkbook for .xlsx files
        try (Workbook workbook = new XSSFWorkbook()) {

            // 2. Create a Sheet
            Sheet sheet = workbook.createSheet("Employees");

            // 3. Create a Header Row
            String[] columns = {"ID", "Name", "Department", "Salary"};
            Row headerRow = sheet.createRow(0);

            // Create cells for the header
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);

                // Optional: Make header bold
                CellStyle headerStyle = workbook.createCellStyle();
                Font font = workbook.createFont();
                font.setBold(true);
                headerStyle.setFont(font);
                cell.setCellStyle(headerStyle);
            }

            // 4. Create Data Rows
            Object[][] employeeData = {
                    {101, "Alice Smith", "Engineering", 85000},
                    {102, "Bob Jones", "Sales", 60000},
                    {103, "Charlie Brown", "HR", 55000}
            };

            int rowNum = 1;
            for (Object[] emp : employeeData) {
                Row row = sheet.createRow(rowNum++);

                row.createCell(0).setCellValue((Integer) emp[0]);
                row.createCell(1).setCellValue((String) emp[1]);
                row.createCell(2).setCellValue((String) emp[2]);
                row.createCell(3).setCellValue((Integer) emp[3]);
            }

            // 5. Auto-size columns for better readability
            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }

            // 6. Write the output to a file
            try (FileOutputStream fileOut = new FileOutputStream("MyFirstExcel.xlsx")) {
                workbook.write(fileOut);
                System.out.println("Excel file created successfully!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

