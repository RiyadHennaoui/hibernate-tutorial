package fr.afpa.controller;

import fr.afpa.model.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionHibernate {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            Student tempStudent1 = new Student("Pauleza", "Wallaz", "wall@domain.com");
            Student tempStudent2 = new Student("Mike", "Doe", "mike@domain.com");
            Student tempStudent3 = new Student("Bonita", "Applebaum", "bonita@domain.com");

            session.beginTransaction();
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);
            session.getTransaction().commit();

        }finally {
            factory.close();
        }
    }
}
