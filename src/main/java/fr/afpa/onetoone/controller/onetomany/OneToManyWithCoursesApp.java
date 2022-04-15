package fr.afpa.onetoone.controller.onetomany;

import fr.afpa.onetoone.model.Course;
import fr.afpa.onetoone.model.Instructor;
import fr.afpa.onetoone.model.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyWithCoursesApp {

    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();



        try {
            session.beginTransaction();

            Instructor instructorTemp = session.get(Instructor.class, 1);

//            Course course1 = new Course("Guitar");
//            Course course2 = new Course("Paintball");
//
//            instructorTemp.add(course1);
//            instructorTemp.add(course2);
//
//            session.save(course1);
//            session.save(course2);

//            System.out.println("Instructor: " + instructorTemp);
//            System.out.println("Courses: " + instructorTemp.getCourses());

            Course courseTemp = session.get(Course.class, 1);

            session.delete(courseTemp);




            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }

    }
}
