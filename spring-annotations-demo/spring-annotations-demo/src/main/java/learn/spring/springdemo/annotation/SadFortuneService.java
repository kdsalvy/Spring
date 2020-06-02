package learn.spring.springdemo.annotation;

public class SadFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "Sadness is just a state of mind";
    }

}
