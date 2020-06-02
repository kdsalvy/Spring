package learn.spring.hibernate.mapping.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learn.spring.hibernate.demo.entity.Course;
import learn.spring.hibernate.demo.entity.Instructor;
import learn.spring.hibernate.demo.entity.InstructorDetail;
import learn.spring.hibernate.demo.entity.Review;
import learn.spring.hibernate.demo.entity.Student;

public class ManyToManyBiMapping {

    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .addAnnotatedClass(Course.class)
            .addAnnotatedClass(Review.class)
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            Course c1 = session.get(Course.class, 1);
            Course c2 = session.get(Course.class, 2);
            Course c3 = session.get(Course.class, 3);
            Course c4 = session.get(Course.class, 4);

            Student s1 = session.get(Student.class, 1);
            Student s2 = session.get(Student.class, 3);
            Student s3 = session.get(Student.class, 4);
            Student s4 = session.get(Student.class, 5);

            s1.addCourse(c1);
            s1.addCourse(c2);
            s1.addCourse(c3);
            s1.addCourse(c4);
            
            s2.addCourse(c1);
            s2.addCourse(c2);
            s2.addCourse(c3);
            s2.addCourse(c4);
            
            s3.addCourse(c1);
            s3.addCourse(c2);
            s3.addCourse(c3);
            s3.addCourse(c4);
            
            s4.addCourse(c1);
            s4.addCourse(c2);
            s4.addCourse(c3);
            s4.addCourse(c4);

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
