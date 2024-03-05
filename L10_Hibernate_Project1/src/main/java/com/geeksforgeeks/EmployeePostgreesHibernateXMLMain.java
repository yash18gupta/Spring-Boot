package com.geeksforgeeks;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class EmployeePostgreesHibernateXMLMain {

    public static void main(String[] args) {
        Configuration c = new Configuration();

        SessionFactory sf = c.configure("hbm-postgess.cfg.xml").buildSessionFactory();

        System.out.println(sf);

        Session session = sf.openSession();

        Employee e = new Employee(0, "Yash", 2000);

        session.save(e);
        session.close();
    }

}