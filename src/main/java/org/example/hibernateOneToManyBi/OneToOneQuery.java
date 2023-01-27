package org.example.hibernateOneToManyBi;

import org.example.hibernateOneToManyBi.entity.Department;
import org.example.hibernateOneToManyBi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneQuery {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try {

            /*
            session = factory.getCurrentSession();
            Department dep = new Department("IT", 2000, 500);
            Employee emp1 = new Employee("Kirill", "Karnauhov", 500);
            Employee emp2 = new Employee("Alex", "Frost", 2000);
            Employee emp3 = new Employee("Leha", "loy", 1500);

            dep.addEmployeeToDepartment(emp1);
            dep.addEmployeeToDepartment(emp2);
            dep.addEmployeeToDepartment(emp3);

            session.beginTransaction();

            session.save(dep);

            session.getTransaction().commit();
            System.out.println("Done!");

             */




            session = factory.getCurrentSession();

            session.beginTransaction();
            System.out.println("Get department");
            Department department = session.get(Department.class, 3);

            System.out.println("Show department");
            System.out.println(department);

            System.out.println("Show employees from department");
            System.out.println(department.getEmps());

            session.getTransaction().commit();
            System.out.println("Done!");




            /*
            session = factory.getCurrentSession();

            session.beginTransaction();

            Employee employee = session.get(Employee.class,1);

            System.out.println(employee);
            System.out.println(employee.getDepartment());

            session.getTransaction().commit();
            System.out.println("Done!");

             */

            /*
            session = factory.getCurrentSession();

            session.beginTransaction();

            Employee employee = session.get(Employee.class,3);

            session.delete(employee);

            session.getTransaction().commit();
            System.out.println("Done!");

             */

        } finally {
            session.close();
            factory.close();
        }

    }
}
