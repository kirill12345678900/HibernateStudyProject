package org.example.hibarnate1;

import org.example.hibarnate1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateEmp {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();


        try { // update by id
            Session session = factory.getCurrentSession();

            session.beginTransaction();

//            Employee employee = session.get(Employee.class, 1); by id
//            employee.setSalary(1500);

            session.createQuery("update Child set salary=1000 " +
                    "where name='Alex'").executeUpdate();
            session.getTransaction().commit();


            System.out.println("Done!");

        } finally {
            factory.close();
        }

    }
}
