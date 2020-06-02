package learn.spring.springdemo.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("") // empty is singletone and for others you need to specify
@Component
// Default bean Id will be assigned on not specifying any i.e. tennisCoach
public class TennisCoach implements Coach {

    // Field Injection
    // Qualifiers are required when we have multiple implementations of an
    // interface and we need to autowire a specific one
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    @PostConstruct
    public void myInitMethod() {
        System.out.println("TennisCoach.myInitMethod()");
    }
    
    @PreDestroy
    public void myDestroyMethod() {
        System.out.println("TennisCoach.myDestroyMethod()");
    }
    
    // Constructor Injection
    // @Autowired // annotation over constructor is optional
    // public TennisCoach(FortuneService fortuneService) {
    // this.fortuneService = fortuneService;
    // }

    // Setter Injection
    // In Autowiring any method name can be used unlike xml config where
    // exact setter name syntax is required
    // @Autowired
    // public void setFortuneServiceCustom(FortuneService fortuneService) {
    // this.fortuneService = fortuneService;
    // }

    // Property file value injection
    @Value("${tennisCoach.email}")
    private String emailAddress;

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
