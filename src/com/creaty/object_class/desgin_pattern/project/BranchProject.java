package com.creaty.object_class.desgin_pattern.project;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyx on 2015/11/22.
 */
public class BranchProject extends Project {

    private List<Project> subProject;

    public BranchProject(String name) {
        super(name);
        subProject = new ArrayList<>();
    }

    public boolean addSubProject(Project project) {
        return subProject.add(project);
    }

    public boolean removeSubProject(Project project) {
        return subProject.remove(project);
    }

    public List<Project> getSubProject() {
        return subProject;
    }

}
