package fr.afpa.controller;

import fr.afpa.model.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ConnectionHibernate {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            Student tempStudent1 = new Student("Pauleza", "Wallaz", "wall@domain.com");
            Student tempStudent2 = new Student("Mike", "Doe", "mike@yahoo.com");
            Student tempStudent3 = new Student("Bonita", "Applebaum", "bonita@gmail.com");

            //create students in database
            session.beginTransaction();
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            session.getTransaction().commit();
//
//            //Read student in database
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Student thisStudent = session.get(Student.class, tempStudent1.getId());
//            System.out.println(thisStudent);
//            //Update
//            thisStudent.setFirstName("Scooby");
//            session.getTransaction().commit();

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
//            session.getTransaction().commit();

            //Read with Query
            /**
            session = factory.getCurrentSession();

            session.beginTransaction();

            List<Student> students = session.createQuery("from Student").getResultList();

            displayStudents(students);

            students = session.createQuery("from Student s where s.lastName='Doe'").getResultList();

            displayStudents(students);
            students = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Pauleza'").getResultList();

            displayStudents(students);

            students = session.createQuery("from Student s where s.email LIKE '%domain.com'").getResultList();

            displayStudents(students);

            session.getTransaction().commit();
            */

            //Delete

            session = factory.getCurrentSession();
            session.beginTransaction();
            Student delStudent = session.get(Student.class, 1L);
            session.delete(delStudent);
            session.createQuery("delete from Student where id=3").executeUpdate();
            session.getTransaction().commit();



        }finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> students) {
        students.forEach(System.out::println);
    }
}
