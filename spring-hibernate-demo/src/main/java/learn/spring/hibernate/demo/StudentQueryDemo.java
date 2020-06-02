package learn.spring.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learn.spring.hibernate.demo.entity.Student;

public class StudentQueryDemo {

    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();

        // create session
        Session session = null;

        try {
            session = factory.getCurrentSession();
            // start a transaction
            session.beginTransaction();
            // query students
            List<?> allStudents = session.createQuery("from Student")
                .list();
            allStudents.forEach(System.out::println);

            List<?> studentsWithEmail = session.createQuery("FROM Student s WHERE s.email LIKE '%gmail.com'")
                .list();
            studentsWithEmail.forEach(System.out::println);

        } catch (Exception ex) {
            session.close();
        } finally {
            factory.close();
        }

    }

}
