package org.geeksforgeeks.jbdl60.many2many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class M2MMain {

    public static void main(String[] args) {
        Configuration c = new Configuration();

        SessionFactory sf = c.configure("hbm-m2m.cfg.xml").buildSessionFactory();
        System.out.println(sf);

        Session s = sf.openSession();

        System.out.println("Session started:"+s);

        Transaction tx = s.beginTransaction();


        Cart cart1 = new Cart();
        cart1.setName("Big Billion Days - 1");

        Items i1= new Items("iphone", 20000);
        Items i2= new Items("macbook", 25000);

        Set<Items> itemsSet1 = new HashSet<Items>();
        itemsSet1.add(i1);
        itemsSet1.add(i2);

        cart1.setItems(itemsSet1);
        cart1.setTotal(100*2+50*5);



        Cart cart2 = new Cart();
        cart2.setName("Big  billion day cart- 2");


        Items i3= new Items("iphone pro", 100000);
        Items i4= new Items("macbook pro", 150000);

        Set<Items> itemsSet2 = new HashSet<Items>();
        itemsSet2.add(i3);
        itemsSet2.add(i4);

        cart2.setItems(itemsSet2);
        cart2.setTotal(100*2+50*5);

        Set<Cart> cartSet = new HashSet<Cart>();
        cartSet.add(cart1);
        cartSet.add(cart2);

        //i4.setCarts(cartSet);
        s.save(cart1);
        s.save(cart2);
        s.save(i1);
        s.save(i2);
        s.save(i3);
        s.save(i4);

        s.flush();
        tx.commit();

        s.close();
        sf.close();
    }

}
