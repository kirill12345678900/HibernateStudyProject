package org.example.hibarnateOneToOne;

import org.example.hibarnateOneToOne.entity.Detail;
import org.example.hibarnateOneToOne.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneQuery2 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;
        try {


            /*
            session = factory.getCurrentSession();
            Employee employee = new Employee("Alexey", "Loy", "HR", 700);
            Detail detail = new Detail("Minsk", "312312312", "Leha@test");

            employee.setEmpDetail(detail);
            detail.setEmployee(employee);

            session.beginTransaction();

            session.save(detail);

            session.getTransaction().commit();


            System.out.println("Done!");

             */

            /*
            session = factory.getCurrentSession();

            session.beginTransaction();

            Detail detail = session.get(Detail.class, 4);
            System.out.println(detail.getEmployee());

            session.getTransaction().commit();


            System.out.println("Done!");

             */
            session = factory.getCurrentSession();

            session.beginTransaction();

            Detail detail = session.get(Detail.class, 1);
            detail.getEmployee().setEmpDetail(null);
            session.delete(detail);

            session.getTransaction().commit();


            System.out.println("Done!");


        } finally {
            session.close();
            factory.close();
        }

    }
}
