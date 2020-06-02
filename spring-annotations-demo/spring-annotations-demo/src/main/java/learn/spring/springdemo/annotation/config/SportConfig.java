package learn.spring.springdemo.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import learn.spring.springdemo.annotation.Coach;
import learn.spring.springdemo.annotation.FortuneService;
import learn.spring.springdemo.annotation.SadFortuneService;
import learn.spring.springdemo.annotation.SwimCoach;

@Configuration
// @ComponentScan("learn.spring.springdemo.annotation") // optional if config class lies in the base package
// no need to do component scan if bean are defined explicitly
@PropertySource("classpath:sport.properties")
public class SportConfig {

    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }

    @Bean
    public Coach swimCoach() {
        return new SwimCoach(sadFortuneService());
    }

}
