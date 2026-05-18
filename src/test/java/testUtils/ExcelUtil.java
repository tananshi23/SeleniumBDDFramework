package testUtils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelUtil {


   // String testCaseName = ConfigReader.getProperty("testCaseName");

    public static Map<String, String> getTestData(String testCaseName) {

        String filePath = ConfigReader.getProperty("excelPath");
        String sheetName = ConfigReader.getProperty("sheetName");
        Map<String, String> dataMap = new HashMap<>();

        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet(sheetName);


            Row headerRow = sheet.getRow(0);

            DataFormatter formatter = new DataFormatter();

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {

                Row row = sheet.getRow(i);

                if (row.getCell(0).getStringCellValue()
                        .equalsIgnoreCase(testCaseName)) {

                    for (int j = 0; j < row.getLastCellNum(); j++) {

                        String key = headerRow.getCell(j)
                                .getStringCellValue();

                        Cell cell = row.getCell(j);

                        String cellValue;

                        if (cell == null) {
                            cellValue = "";
                        } else {
                            cellValue = formatter.formatCellValue(cell);
                        }

                        dataMap.put(key, cellValue);
                    }

                    break;
                }
            }

            workbook.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataMap;
    }
}