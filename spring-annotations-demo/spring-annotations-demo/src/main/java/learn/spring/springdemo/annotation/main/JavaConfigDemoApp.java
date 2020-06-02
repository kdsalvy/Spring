package learn.spring.springdemo.annotation.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import learn.spring.springdemo.annotation.TennisCoach;
import learn.spring.springdemo.annotation.config.SportConfig;

public class JavaConfigDemoApp {

    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
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
