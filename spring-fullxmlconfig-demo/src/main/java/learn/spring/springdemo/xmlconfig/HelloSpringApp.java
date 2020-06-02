package learn.spring.springdemo.xmlconfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

// Inversion of Control(Create and manager objects) example
public class HelloSpringApp {

    public static void main(String[] args) {
        // load spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // retrieve bean from spring container
        Coach coach = context.getBean("myCoach", Coach.class);
        // call methods on the bean
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        System.out.println(coach.getEmailAddress());
        System.out.println(coach.getTeam());
        // close the context
        context.close();
    }

}
