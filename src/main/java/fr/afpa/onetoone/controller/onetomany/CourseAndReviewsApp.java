package fr.afpa.onetoone.controller.onetomany;

import fr.afpa.onetoone.model.Course;
import fr.afpa.onetoone.model.Instructor;
import fr.afpa.onetoone.model.InstructorDetail;
import fr.afpa.onetoone.model.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class CourseAndReviewsApp {

    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();



        try {
            session.beginTransaction();

            Instructor instructorTemp = session.get(Instructor.class, 1);

            Course course1 = new Course("Pacman - How To Scrore One Millon Points");

            course1.addReview(new Review("Super"));
            course1.addReview(new Review("Génail"));
            course1.addReview(new Review("Nuuuuuuull"));


            session.save(course1);





            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }

    }
}
