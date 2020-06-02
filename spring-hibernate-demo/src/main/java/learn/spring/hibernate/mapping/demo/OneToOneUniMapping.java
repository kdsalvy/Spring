package learn.spring.hibernate.mapping.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learn.spring.hibernate.demo.entity.Instructor;
import learn.spring.hibernate.demo.entity.InstructorDetail;

public class OneToOneUniMapping {
    public static void main(String... args) {
        // Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .buildSessionFactory();

        // create session
        Session session = null;

        try {
            session = factory.getCurrentSession();
            Instructor instructor = new Instructor("Saurabh", "Kedia", "kedia.saurabh@gmail.com");
            InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com/kedia.saurabh", "coding");
            instructor.setInstructorDetail(instructorDetail);
            session.beginTransaction();
            session.save(instructor);
            session.getTransaction()
                .commit();
        } catch (Exception ex) {
            session.close();
        } finally {
            factory.close();
        }

    }
}
