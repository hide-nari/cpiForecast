package com.hidenari;

import com.hidenari.service.ExcelFileImport;
import com.hidenari.service.MatchLogic;

public class Main {
    public static void main(String[] args) {
        ExcelFileImport.importExcelProject();
        ExcelFileImport.importExcelPlan();
        MatchLogic.matchProjectPlan();
    }
}