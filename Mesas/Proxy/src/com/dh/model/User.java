package com.dh.model;

public class User {
    private String name;
    private Plan plan;

    public User(String name, Plan plan) {
        this.name = name;
        this.plan = plan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }
}
