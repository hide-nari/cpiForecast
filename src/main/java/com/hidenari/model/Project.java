package com.hidenari.model;

import lombok.Data;

public @Data class Project {
    private String number;
    private String system;
    private String name;
    private Double estimate;
    private Double workPlanedValue;
    private String workMatchType = "no match";
}