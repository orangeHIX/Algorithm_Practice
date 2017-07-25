package com.creaty.object_class.desgin_pattern.project;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyx on 2015/11/22.
 */
public abstract class Project {
    //项目都有名称
    private String name = "";
    private Manager manager;
    private List<Staff> employees;

    public Project(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    public void setManager(Manager manager) {
        if (this.manager != null) {
            this.manager.setProject(null);
        }
        this.manager = manager;
        this.manager.setProject(this);
    }

    public boolean addStaff(Staff employee) {
        return employees.add(employee);
    }

    public boolean removeStaff(Staff staff) {
        return employees.remove(staff);
    }

    public String getInfo() {
        StringBuilder builder = new StringBuilder("");
        builder.append("项目名称： ").append(this.name).append("\t");
        builder.append("项目管理人： ").append(this.manager).append("\t");
        builder.append("职员：[");
        for (Staff staff : employees) {
            builder.append(staff.getInfo()).append('\t');
        }
        builder.append("]\n");
        return builder.toString();
    }
}
