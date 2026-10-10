package com.hidenari.service;

import com.hidenari.model.Project;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelFileImport {

    public static void importExcelProject() {
        List<Project> projectsLists = new ArrayList<>();

        try (
                InputStream inputStream = new FileInputStream(".excel/projects.xlsx")
        ) {
            Workbook workBook = WorkbookFactory.create(inputStream);
            Sheet sheetBook = workBook.getSheetAt(0);
            int rowCount = sheetBook.getLastRowNum();

            for (int i = 0; i <= rowCount; i++) {
                Row row = sheetBook.getRow(i);

                Project project = new Project();

                for (int j = 0; j < row.getLastCellNum(); j++) {
                    Cell cell = row.getCell(j);
                    String cellValue = "";
                    String inputArray = "";
                    switch (cell.getCellType()) {
                        case STRING -> cellValue = cell.getStringCellValue();
                        case NUMERIC -> cellValue = String.valueOf(cell.getNumericCellValue());
                        case null, default -> {
                        }
                    }
                    switch (j) {
                        case 0 -> project.name = cellValue;
                        case 1 -> project.number = cellValue;
                        case 2 -> project.system = cellValue;
                        case 3 -> project.estimate = Double.valueOf(cellValue);
                    }
                }

                projectsLists.add(project);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        for (Project outStr : projectsLists) {
            System.out.println(outStr.toString());
        }
    }

    public static void importExcelPlan() {
        System.out.println("plan");
    }
}
