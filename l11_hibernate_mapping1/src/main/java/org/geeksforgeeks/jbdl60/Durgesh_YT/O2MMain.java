package org.geeksforgeeks.jbdl60.Durgesh_YT;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class O2MMain {
    public static void main(String[] args) {
        Configuration c = new Configuration();

        SessionFactory sf = c.configure("question-hbm.cfg.xml").buildSessionFactory();

        Question q1 = new Question();
        q1.setId(100);
        q1.setQuestion("What is Java?");

        List<Answer> list1 = new ArrayList<Answer>();

        Answer ans1 = new Answer();
        ans1.setId(500);
        ans1.setAnswer("Java is a programming language");
        ans1.setQuestion(q1);

        Answer ans2 = new Answer();
        ans2.setId(501);
        ans2.setAnswer("Java is object orientated language");
        ans2.setQuestion(q1);

        list1.add(ans1);
        list1.add(ans2);
        q1.setAnswers(list1);

        Session s = sf.openSession();

        Transaction tx = s.beginTransaction();

        s.save(q1);

        s.save(ans1);
        s.save(ans2);

        tx.commit();
        s.close();
        sf.close();
    }
}
