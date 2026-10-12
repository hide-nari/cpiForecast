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

        System.out.println("---ProjectList---");
        for (Project project : projectsLists) {
            System.out.println(project);
        }

        List<Plan> plansLists = ExcelFileImport.importExcelPlan();

        System.out.println("---PlanList---");
        for (Plan plan : plansLists) {
            System.out.println(plan);
        }
        System.out.println("---Result---");

        MatchLogic.matchProjectPlan(projectsLists, plansLists);

        projectsLists.sort(Comparator.comparing((Project p) -> p.getEstimate() / p.getWorkPlanedValue()).reversed());

        for (Project project : projectsLists) {
            System.out.println(
                    "★★★" + project.getEstimate() / project.getWorkPlanedValue() + "★★★:" +
                            project.getName() + ":" + project.getSystem() + ":[Estimate:" + project.getEstimate() + "]:{Plan:" +
                            project.getWorkPlanedValue() + "}:" + project.getWorkMatchType());
        }

    }
}