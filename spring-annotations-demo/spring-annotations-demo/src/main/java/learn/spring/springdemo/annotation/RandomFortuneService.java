package learn.spring.springdemo.annotation;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

    private String[] fortunes = { "Today is your lucky day", "It's gonna rain today", "Will be your happiest day" };

    @Override
    public String getFortune() {
        return fortunes[new Random().nextInt(2)];
    }

}

