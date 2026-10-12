package com.hidenari.service;

import com.hidenari.model.Plan;
import com.hidenari.model.Project;

import java.util.List;

public class MatchLogic {
    public static void matchProjectPlan(List<Project> projectsLists, List<Plan> plansLists) {
        for (Project project : projectsLists) {
            project.setWorkPlanedValue(0.0);
            plansLists.stream()
                    .filter(p -> p.getSystem().equals(project.getSystem()))
                    .filter(p -> p.getNumber().equals(project.getNumber()))
                    .forEach(p -> {
                        project.setWorkPlanedValue(p.getPlanedValue());
                        project.setWorkMatchType("number match");
                    });
            if (project.getWorkMatchType().equals("no match")) {
                plansLists.stream()
                        .filter(p -> p.getSystem().equals(project.getSystem()))
                        .filter(p -> p.getName().equals(project.getName()))
                        .forEach(p -> {
                            project.setWorkPlanedValue(p.getPlanedValue());
                            project.setWorkMatchType("name match");
                        });
            }
        }
    }
}
