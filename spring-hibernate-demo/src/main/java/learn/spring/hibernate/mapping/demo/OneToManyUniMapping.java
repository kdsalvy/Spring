package learn.spring.hibernate.mapping.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learn.spring.hibernate.demo.entity.Course;
import learn.spring.hibernate.demo.entity.Instructor;
import learn.spring.hibernate.demo.entity.InstructorDetail;
import learn.spring.hibernate.demo.entity.Review;

public class OneToManyUniMapping {

    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .addAnnotatedClass(Course.class)
            .addAnnotatedClass(Review.class)
            .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            Course course = session.get(Course.class, 1);
            System.out.println(course);

            Review review1 = new Review("Good");
            Review review2 = new Review("Great");
            Review review3 = new Review("Average");
            Review review4 = new Review("Boo");

            course.addReview(review1);
            course.addReview(review2);
            course.addReview(review3);
            course.addReview(review4);

            session.save(course);
            session.getTransaction()
                .commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            session.close();
        } finally {
            factory.close();
        }

    }

}
