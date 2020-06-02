package learn.spring.hibernate.mapping.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learn.spring.hibernate.demo.entity.Instructor;
import learn.spring.hibernate.demo.entity.InstructorDetail;

public class OneToOneBiMapping {
    public static void main(String... args) {
        // Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            int id = 1;
            session.beginTransaction();
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
            System.out.println(instructorDetail);
            Instructor instructor = instructorDetail.getInstructor();
            System.out.println(instructor);
            session.getTransaction()
                .commit();
        } catch (Exception ex) {
            session.close();
        } finally {
            factory.close();
        }

    }
}
