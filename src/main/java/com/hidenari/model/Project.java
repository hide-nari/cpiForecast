package com.hidenari.model;

public class Project {
    public String number;
    public String system;
    public String name;
    public Double estimate;
    public Double workPlanedValue;
    public String workMatchType;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Project{");
        sb.append("number='").append(number).append('\'');
        sb.append(", system='").append(system).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", estimate=").append(estimate);
        sb.append(", workPlanedValue=").append(workPlanedValue);
        sb.append(", workMatchType='").append(workMatchType).append('\'');
        sb.append('}');
        return sb.toString();
    }
}