package com.creaty.object_class.desgin_pattern.project;

/**
 * Created by hyx on 2015/11/22.
 */
public class Manager extends Staff {
    Project project;

    public Manager(String name) {
        super(name);
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
