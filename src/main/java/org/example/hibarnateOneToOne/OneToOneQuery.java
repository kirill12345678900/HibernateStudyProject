package org.example.hibarnateOneToOne;

import org.example.hibarnateOneToOne.entity.Detail;
import org.example.hibarnateOneToOne.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneQuery {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;
        try {
            /*
            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Alex", "Frost", "IT", 1500);
            Detail detail = new Detail("Minsk", "98654321", "Alex@test");
            employee.setEmpDetail(detail);

            session.beginTransaction();

            session.save(employee);

            session.getTransaction().commit();


            System.out.println("Done!");

             */

            /*
            session= factory.getCurrentSession();


            session.beginTransaction();

            Employee employee = session.get(Employee.class, 1);
            System.out.println(employee.getEmpDetail());

            session.getTransaction().commit();


            System.out.println("Done!");

             */

            session= factory.getCurrentSession();


            session.beginTransaction();

            Employee employee = session.get(Employee.class, 2);
            session.delete(employee);

            session.getTransaction().commit();


            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }

    }
}
