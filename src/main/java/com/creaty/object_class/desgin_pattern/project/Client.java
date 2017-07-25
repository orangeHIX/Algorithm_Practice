package com.creaty.object_class.desgin_pattern.project;

/**
 * Created by hyx on 2015/11/22.
 */
public class Client {

    public static void main(String[] args) {
        Worker a = new Worker("a");
        Worker b = new Worker("b");
        Worker c = new Worker("c");
        Worker d = new Worker("d");
        Worker e = new Worker("e");
        Worker f = new Worker("f");
        Worker g = new Worker("g");
        Worker h = new Worker("h");
        Worker i = new Worker("i");
        Worker j = new Worker("j");
        Worker k = new Worker("k");
        Manager zhang = new Manager("zhang");
        Manager li = new Manager("li");
        Manager wang = new Manager("wang");

        LeafProject A = new LeafProject("A");
        LeafProject B = new LeafProject("B");
        LeafProject C = new LeafProject("C");
        LeafProject D = new LeafProject("D");
        BranchProject dao = new BranchProject("dao");
        BranchProject la = new BranchProject("la");
        BranchProject mi = new BranchProject("mi");


        A.addStaff(a);
        A.addStaff(b);
        A.addStaff(c);

        B.addStaff(d);
        B.addStaff(e);

        C.addStaff(f);

        D.addStaff(g);

        BranchProject root = dao;
        root.addSubProject(la);
        root.addSubProject(mi);
        la.addSubProject(A);
        la.addSubProject(B);
        la.addSubProject(C);
        la.addSubProject(D);
        System.out.print(root.getInfo());
        for (Project project : root.getSubProject()) {
            System.out.print(project.getInfo());
        }
        for (Project project : la.getSubProject()) {
            System.out.print(project.getInfo());
        }
    }
}
