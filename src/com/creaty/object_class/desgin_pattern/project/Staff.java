package com.creaty.object_class.desgin_pattern.project;

/**
 * Created by hyx on 2015/11/22.
 */
public abstract class Staff {
    //公司每个人都有名称
    private String name = "";

    public Staff(String name) {
        this.name = name;
    }

    //获得员工信息

    public String getInfo() {
        String info = "";
        info = "姓名： " + this.name;
        return info;
    }
}
