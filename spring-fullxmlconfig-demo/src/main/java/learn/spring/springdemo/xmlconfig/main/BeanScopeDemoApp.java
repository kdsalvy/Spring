package learn.spring.springdemo.xmlconfig.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import learn.spring.springdemo.xmlconfig.Coach;

public class BeanScopeDemoApp {

    public static void main(String[] args) {

        // load the spring configuration file
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        // retrieve bean from spring container
        Coach coachA = applicationContext.getBean("myCoach", Coach.class);

        Coach coachB = applicationContext.getBean("myCoach", Coach.class);

        // check if both beans are same
        boolean result = coachA == coachB;

        System.out.println("Pointing to the same object: " + result 
            + "\ncoachA memory location: " + coachA 
            + "\ncoachB memory location: " + coachB);

        applicationContext.close();
    }

}
