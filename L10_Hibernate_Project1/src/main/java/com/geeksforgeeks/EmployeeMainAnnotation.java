package com.geeksforgeeks;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class EmployeeMainAnnotation {

    public static void main(String[] args) {
        Configuration c = new Configuration();

        SessionFactory sf = c.configure("hbm-annotation.cfg.xml").buildSessionFactory();

        System.out.println(sf);

        Session session = sf.openSession();

        EmployeeAnnotation e = new EmployeeAnnotation(0, "Yash", 2000);

        Transaction tx = session.beginTransaction();
        session.save(e);
        session.flush();
        tx.commit();
        session.close();
    }

}