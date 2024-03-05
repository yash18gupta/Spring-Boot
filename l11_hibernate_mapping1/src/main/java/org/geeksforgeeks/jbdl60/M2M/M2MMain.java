package org.geeksforgeeks.jbdl60.M2M;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class M2MMain {
    public static void main(String[] args) {
        Configuration c = new Configuration();
        SessionFactory sf = c.configure("emp-hbm.cfg.xml").buildSessionFactory();

        Emp e1 = new Emp();
        e1.setEmpID(101);
        e1.setEmpName("Yash");

        Emp e2 = new Emp();
        e2.setEmpID(102);
        e2.setEmpName("Tanisha");


        Project p1 = new Project();
        p1.setProjectId(501);
        p1.setProjectName("Java");

        Project p2 = new Project();
        p2.setProjectId(502);
        p2.setProjectName("Hibernate");


        List<Project> list1 = new ArrayList<Project>();
        list1.add(p1);
        list1.add(p2);
        e1.setProjects(list1);

        List<Project> list2 = new ArrayList<Project>();
        list2.add(p1);
        e2.setProjects(list2);

        List<Emp> list3 = new ArrayList<Emp>();
        list3.add(e1);
        list3.add(e2);

        p1.setEmps(list3);

        List<Emp> list4 = new ArrayList<Emp>();
        list4.add(e1);

        p2.setEmps(list4);


        Session s = sf.openSession();

        Transaction tx = s.beginTransaction();

        s.save(e1);
        s.save(e2);
        s.save(p1);
        s.save(p2);


        tx.commit();
        s.close();
        sf.close();
    }
}
