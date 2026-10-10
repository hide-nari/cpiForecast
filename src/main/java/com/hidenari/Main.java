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
        List<Plan> plansLists = ExcelFileImport.importExcelPlan();

        for (Plan plan : plansLists) {
            System.out.println(plan);
        }

        MatchLogic.matchProjectPlan(projectsLists, plansLists);

        projectsLists.sort(Comparator.comparing((Project p) -> p.estimate / p.workPlanedValue).reversed());

        for (Project project : projectsLists) {
            System.out.println(
                    "★★★" + project.estimate / project.workPlanedValue + "★★★:" +
                            project.name + ":" + project.system + ":[Estimate:" + project.estimate + "]:{Plan:" +
                            project.workPlanedValue + "}:" + project.workMatchType);
        }

    }
}