package org.example.hibarnate1;

import org.example.hibarnate1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteEmp {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();


        try { // delete by id, name
            Session session = factory.getCurrentSession();

            session.beginTransaction();

            //    Employee employee = session.get(Employee.class, 5);
            //session.delete(employee);

            session.createQuery("delete Child " + "where name='Alex'")
                            .executeUpdate();
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }

    }
}
