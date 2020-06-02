package learn.spring.springdemo.annotation.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import learn.spring.springdemo.annotation.TennisCoach;

public class AnnotationDemoApp {

    public static void main(String[] args) {
        // read spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // get bean from container
        TennisCoach coach = context.getBean("tennisCoach", TennisCoach.class);
        // call method on bean
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        System.out.println(coach.getEmailAddress());
        // close the context
        context.close();
    }

}
