package com.hidenari.model;

import lombok.Data;

public @Data class Plan {
    private String number;
    private String system;
    private String name;
    private Double planedValue;
}