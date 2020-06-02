package learn.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learn.spring.hibernate.demo.entity.Student;

public class StudentCreateDemo {

    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();

        // create session
        Session session = null;

        try {
            // use session object to save the student object
            session = factory.getCurrentSession();
            // create a student object
            Student student = new Student("Saurabh", "Kedia", "kedia.saurabh@gmail.com");
            // start a transaction
            session.beginTransaction();
            // save the student object
            session.save(student);
            // commit transaction
            session.getTransaction()
                .commit();
        } catch (Exception ex) {
            session.close();
        } finally {
            factory.close();
        }

    }

}
