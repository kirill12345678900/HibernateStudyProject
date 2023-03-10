package org.example.hibernateManyToMany;

import org.example.hibernateManyToMany.entity.Child;
import org.example.hibernateManyToMany.entity.Section;
import org.example.hibernateOneToManyBi.entity.Department;
import org.example.hibernateOneToManyBi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToManyQuery {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;
        try {

            /*
            session = factory.getCurrentSession();

            Section section1 = new Section("Football");

            Child child1 = new Child("Kirill", 5);
            Child child2 = new Child("Alex", 4);
            Child child3 = new Child("Leha", 7);

            section1.addChildToSection(child1);
            section1.addChildToSection(child2);
            section1.addChildToSection(child3);

            session.beginTransaction();

            session.save(section1);

            session.getTransaction().commit();
            System.out.println("Done!");

             */


            /*
            session = factory.getCurrentSession();

            Section section1 = new Section("Volleyball");
            Section section2 = new Section("Hockey");
            Section section3 = new Section("Math");

            Child child1 = new Child("igor", 5);

            child1.addSectionToChild(section1);
            child1.addSectionToChild(section2);
            child1.addSectionToChild(section3);

            session.beginTransaction();

            session.save(child1);

            session.getTransaction().commit();
            System.out.println("Done!");


             */

            /*

            session = factory.getCurrentSession();


            session.beginTransaction();

            Section section = session.get(Section.class, 1);
            System.out.println(section);
            System.out.println(section.getChildren());

            session.getTransaction().commit();
            System.out.println("Done!");

             */

            /*

            session = factory.getCurrentSession();


            session.beginTransaction();

            Child child = session.get(Child.class, 4);
            System.out.println(child);
            System.out.println(child.getSections());

            session.getTransaction().commit();
            System.out.println("Done!");

             */

        } finally {
            session.close();
            factory.close();
        }

    }
}
