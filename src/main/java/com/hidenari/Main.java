package com.hidenari;

import com.hidenari.model.Plan;
import com.hidenari.model.Project;
import com.hidenari.service.ExcelFileImport;
import com.hidenari.service.MatchLogic;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Project> projectsLists = ExcelFileImport.importExcelProject();
//        for (Project outStr : projectsLists) {
//            System.out.println(outStr.toString());
//        }
        List<Plan> plansLists = ExcelFileImport.importExcelPlan();
//        for (Plan outStr : plansLists) {
//            System.out.println(outStr.toString());
//        }

        MatchLogic.matchProjectPlan(projectsLists, plansLists);
//        for (Project outStr : projectsLists) {
//            System.out.println(outStr.toString());
//        }

        projectsLists.sort(Comparator.comparing((Project p) -> p.estimate / p.workPlanedValue).reversed());

        for (Project project : projectsLists) {
            System.out.println(project.name + ":" + project.system + ":★★★" + project.estimate / project.workPlanedValue + "★★★:" + project.workMatchType);
        }

    }
}