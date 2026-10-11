package com.hidenari.service;

import com.hidenari.model.Plan;
import com.hidenari.model.Project;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelFileImport {

    public static List<Project> importExcelProject() {
        List<Project> projectsLists = new ArrayList<>();

        try (
                InputStream inputStream = new FileInputStream(".excel/projects.xlsx")
        ) {
            Workbook workBook = WorkbookFactory.create(inputStream);
            Sheet sheetBook = workBook.getSheet("TMS_Request List");
            int rowCount = sheetBook.getLastRowNum();

            for (int i = 0; i <= rowCount; i++) {
                Row row = sheetBook.getRow(i);

                Project project = new Project();

                if (row != null) {
                    for (int j = 0; j < row.getLastCellNum(); j++) {
                        Cell cell = row.getCell(j);
                        String cellValue = "";
                        if (cell != null) {
                            switch (cell.getCellType()) {
                                case STRING -> cellValue = cell.getStringCellValue();
                                case NUMERIC -> cellValue = String.valueOf(cell.getNumericCellValue());
                                case FORMULA -> cellValue = String.valueOf(cell.getNumericCellValue());
                                case null, default -> {
                                    continue;
                                }
                            }
                            switch (j) {
                                case 7 -> project.number = cellValue;
                                case 11 -> project.name = cellValue;
                                case 15 -> project.system = cellValue;
                                case 106 -> {
                                    cellValue = String.valueOf(Double.parseDouble(cellValue) * 140);
                                    project.estimate = Double.valueOf(cellValue);
                                }
                            }
                        }
                    }
                    if (project.estimate != null) {
                        projectsLists.add(project);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return projectsLists;
    }

    public static List<Plan> importExcelPlan() {
        List<Plan> plansLists = new ArrayList<>();

        try (
                InputStream inputStream = new FileInputStream(".excel/plans.xlsx")
        ) {
            Workbook workBook = WorkbookFactory.create(inputStream);
            Sheet sheetBook = workBook.getSheet("9月");
            int rowCount = sheetBook.getLastRowNum();

            for (int i = 0; i <= rowCount; i++) {
                Row row = sheetBook.getRow(i);

                Plan plan = new Plan();

                if (row != null) {

                    for (int j = 0; j < row.getLastCellNum(); j++) {
                        Cell cell = row.getCell(j);
                        String cellValue = "";
                        if (cell != null) {
                            switch (cell.getCellType()) {
                                case STRING -> cellValue = cell.getStringCellValue();
                                case NUMERIC -> cellValue = String.valueOf(cell.getNumericCellValue());
                                case FORMULA -> cellValue = String.valueOf(cell.getNumericCellValue());
                                case null, default -> {
                                    continue;
                                }
                            }
                            switch (j) {
                                case 1 -> plan.number = cellValue;
                                case 3 -> plan.name = cellValue;
                                case 4 -> plan.system = cellValue;
                                case 25 -> plan.planedValue = Double.parseDouble(cellValue);
                            }
                        }
                    }

                    if (plan.planedValue != null) {
                        plansLists.add(plan);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return plansLists;
    }
}
