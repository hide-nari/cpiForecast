package com.hidenari.service;

import com.hidenari.model.Plan;
import com.hidenari.model.Project;

import java.util.List;

public class MatchLogic {
    public static void matchProjectPlan(List<Project> projectsLists, List<Plan> plansLists) {
        for (Project project : projectsLists) {
            project.setWorkPlanedValue(0.0);
            plansLists.stream()
                    .filter(plan -> plan.getSystem().equals(project.getSystem()))
                    .filter(plan -> plan.getNumber().equals(project.getNumber()))
                    .forEach(plan -> {
                        project.setWorkPlanedValue(plan.getPlanedValue());
                        project.setWorkMatchType("number match");
                    });
            if (project.getWorkMatchType().equals("no match")) {
                plansLists.stream()
                        .filter(plan -> plan.getSystem().equals(project.getSystem()))
                        .filter(plan -> plan.getName().equals(project.getName()))
                        .forEach(plan -> {
                            project.setWorkPlanedValue(plan.getPlanedValue());
                            project.setWorkMatchType("name match");
                        });
            }
        }
    }
}
