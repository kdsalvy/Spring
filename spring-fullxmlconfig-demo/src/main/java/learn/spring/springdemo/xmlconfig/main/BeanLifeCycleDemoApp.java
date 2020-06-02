package learn.spring.springdemo.xmlconfig.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import learn.spring.springdemo.xmlconfig.Coach;

public class BeanLifeCycleDemoApp {

    public static void main(String[] args) {

        // load the spring configuration file
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beanLifecycle-applicationContext.xml");

        // retrieve bean from spring container
        Coach coach = applicationContext.getBean("myCoach", Coach.class);

        System.out.println(coach.getDailyFortune());
        applicationContext.close();
    }

}
