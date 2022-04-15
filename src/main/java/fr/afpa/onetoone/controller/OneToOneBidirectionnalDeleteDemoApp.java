package fr.afpa.onetoone.controller;

import fr.afpa.onetoone.model.Instructor;
import fr.afpa.onetoone.model.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneBidirectionnalDeleteDemoApp {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");

        InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!!!");
        Instructor tempInstructor2 = new Instructor("Madhu", "Patel", "madhu@luv2code.com");

        InstructorDetail instructorDetail2 = new InstructorDetail("http://www.youtube.com", "Guitar!!!");

        //associate the objects
        tempInstructor.setInstructorDetail(instructorDetail);
        tempInstructor2.setInstructorDetail(instructorDetail2);


        try {
            session.beginTransaction();
//            session.save(tempInstructor);
//            session.save(tempInstructor2);

            InstructorDetail instructorDetail1 = session.get(InstructorDetail.class, 2);

            System.out.println("the associated instructor: " + instructorDetail1.getInstructor());

            // remeove the associated object reference we need to break bi-directional link
            instructorDetail1.getInstructor().setInstructorDetail(null);
            session.delete(instructorDetail1);

            System.out.println("deleted ! " + instructorDetail1);


            session.getTransaction().commit();

        }catch (Exception ex){
            ex.printStackTrace();

        } finally {
            session.close();
            factory.close();
        }


    }
}
