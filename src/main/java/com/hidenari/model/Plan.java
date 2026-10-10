package com.hidenari.model;

public class Plan {
    public String number;
    public String system;
    public String name;
    public Double planedValue;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Plan{");
        sb.append("number='").append(number).append('\'');
        sb.append(", system='").append(system).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", planedValue=").append(planedValue);
        sb.append('}');
        return sb.toString();
    }
}
