package learn.spring.springdemo.annotation.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import learn.spring.springdemo.annotation.SwimCoach;
import learn.spring.springdemo.annotation.config.SportConfig;

public class SwimJavaConfigDemoApp {

    public static void main(String[] args) {
        // read spring java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
        // get bean from container
        SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);
        // call method on bean
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        System.out.println(coach.getEmailAddress());
        System.out.println(coach.getTeam());
        // close the context
        context.close();
    }

}
