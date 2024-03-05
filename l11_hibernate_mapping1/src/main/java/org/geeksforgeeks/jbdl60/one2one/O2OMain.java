package org.geeksforgeeks.jbdl60.one2one;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class O2OMain {

    public static void main(String[] args) {
        Configuration c = new Configuration();

        SessionFactory sf = c.configure("hbm-o2o.cfg.xml").buildSessionFactory();

        System.out.println(sf);

        Session s = sf.openSession();
        System.out.println("Session started : "+s);

        Transaction tx = s.beginTransaction();

        CustomerTranscation ctx = new CustomerTranscation();
        ctx.setTotal(100);

        Customer cx = new Customer();
        cx.setName("Yash");
        cx.setAddress("Delhi");
        cx.setEmail("yash@gmail.com");

        ctx.setCustomer(cx);
        cx.setTranscation(ctx);

        s.save(ctx);

        s.flush();
        tx.commit();

        s.close();
        sf.close();
    }
}
