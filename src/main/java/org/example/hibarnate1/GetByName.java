package org.example.hibarnate1;

import org.example.hibarnate1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GetByName {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();


        try { // get
            Session session = factory.getCurrentSession();

            session.beginTransaction();

            List<Employee> emps = session.createQuery("from Child " +
                            "where name = 'Alex' and salary>=500")
                            .getResultList();

            for (Employee e: emps) {
                System.out.println(e);
            }

            session.getTransaction().commit();


            System.out.println("Done!");

        } finally {
            factory.close();
        }

    }
}
