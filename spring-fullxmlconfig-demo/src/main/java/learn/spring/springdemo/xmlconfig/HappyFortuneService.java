package learn.spring.springdemo.xmlconfig;

import java.util.Random;

public class HappyFortuneService implements FortuneService {

    private String[] fortunes = { "Today is your lucky day", "It's gonna rain today", "Will be your happiest day" };

    @Override
    public String getFortune() {
        return fortunes[new Random().nextInt(2)];
    }

}
