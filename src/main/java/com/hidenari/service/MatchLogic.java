package com.hidenari.service;

import com.hidenari.model.Plan;
import com.hidenari.model.Project;

import java.util.List;

public class MatchLogic {
    public static void matchProjectPlan(List<Project> projectsLists, List<Plan> plansLists) {
        for (Project project : projectsLists) {
            project.workPlanedValue = 0.0;
            plansLists.stream()
                    .filter(p -> p.system.equals(project.system))
                    .filter(p -> p.number.equals(project.number))
                    .forEach(p -> {
                        project.workPlanedValue = p.planedValue;
                        project.workMatchType = "number match";
                    });
            if (project.workMatchType == null) {
                plansLists.stream()
                        .filter(p -> p.name.equals(project.name))
                        .forEach(p -> {
                            project.workPlanedValue = p.planedValue;
                            project.workMatchType = "name match";
                        });
            }
        }
    }
}
