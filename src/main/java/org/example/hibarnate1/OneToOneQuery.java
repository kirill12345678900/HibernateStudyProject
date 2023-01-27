package org.example.hibarnate1;

import org.example.hibarnate1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneQuery {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();


        try {
            Session session = factory.getCurrentSession();

            session.beginTransaction();


            session.getTransaction().commit();


            System.out.println("Done!");

        } finally {
            factory.close();
        }

    }
}
