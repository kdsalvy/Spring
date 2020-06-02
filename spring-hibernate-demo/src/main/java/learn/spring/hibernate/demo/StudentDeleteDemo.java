package learn.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learn.spring.hibernate.demo.entity.Student;

public class StudentDeleteDemo {

    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();

        // create session
        Session session = null;

        try {
            session = factory.getCurrentSession();
            int id = 2;
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            System.out.println(student);

            session.delete(student);
            session.getTransaction()
                .commit();

        } catch (Exception ex) {
            session.close();
        } finally {
            factory.close();
        }

    }

}
