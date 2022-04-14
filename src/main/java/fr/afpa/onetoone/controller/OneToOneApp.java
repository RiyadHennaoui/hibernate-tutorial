package fr.afpa.onetoone.controller;

import fr.afpa.model.entity.Student;
import fr.afpa.onetoone.model.Instructor;
import fr.afpa.onetoone.model.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneApp {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

//        Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
//
//        InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!!!");
        Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");

        InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "Guitar!!!");

        //associate the objects
        tempInstructor.setInstructorDetail(instructorDetail);


        try {
            session.beginTransaction();

            session.save(tempInstructor);

            session.getTransaction().commit();

        } finally {
            session.close();
        }


    }
}
