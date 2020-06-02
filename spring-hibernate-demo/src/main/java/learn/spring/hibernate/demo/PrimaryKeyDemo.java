package learn.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learn.spring.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // use session object to save the student object
            // create 3 student objects
            Student s1 = new Student("Saurabh", "Kedia", "kedia.saurabh@gmail.com");
            Student s2 = new Student("John", "Doe", "john.doe@gmail.com");
            Student s3 = new Student("Mary", "Public", "mary.public@gmail.com");
            // start a transaction
            session.beginTransaction();
            // save the student objects
            session.save(s1);
            session.save(s2);
            session.save(s3);
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
