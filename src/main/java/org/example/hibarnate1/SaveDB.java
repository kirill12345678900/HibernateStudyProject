package org.example.hibarnate1;

import org.example.hibarnate1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveDB {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();


        try { // add, get
            Session session = factory.getCurrentSession();

            Employee employee = new Employee("Oleg",
                    "Snitch",
                    "HR",
                    700);

            session.beginTransaction();
            session.save(employee);//add
           // session.getTransaction().commit();

            int myId = employee.getId();
           // session = factory.getCurrentSession();
           // session.beginTransaction();
            Employee employee1 = session.get(Employee.class, myId);//select
            session.getTransaction().commit();
            System.out.println(employee1);

        } finally {
            factory.close();
        }

    }
}
