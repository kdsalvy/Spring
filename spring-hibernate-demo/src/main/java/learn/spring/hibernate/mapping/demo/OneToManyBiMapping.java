package learn.spring.hibernate.mapping.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learn.spring.hibernate.demo.entity.Course;
import learn.spring.hibernate.demo.entity.Instructor;
import learn.spring.hibernate.demo.entity.InstructorDetail;

public class OneToManyBiMapping {
    public static void main(String... args) {
        // Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .addAnnotatedClass(Course.class)
            .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            Instructor tempInstructor = new Instructor("abc", "xyz", "abc@gmail.com");

            InstructorDetail instructorDetail = new InstructorDetail("youtubeChannel", "gaming");

            Course c1 = new Course("Maths");
            Course c2 = new Course("Physics");
            Course c3 = new Course("English");

            tempInstructor.setInstructorDetail(instructorDetail);
            tempInstructor.addCourse(c1);
            tempInstructor.addCourse(c2);
            tempInstructor.addCourse(c3);

            session.persist(tempInstructor);
            session.getTransaction()
                .commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            Instructor readInstructor = session.get(Instructor.class, 1);
            System.out.println("Lazy fetch demo");
            System.out.println(readInstructor.getCourses());
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
