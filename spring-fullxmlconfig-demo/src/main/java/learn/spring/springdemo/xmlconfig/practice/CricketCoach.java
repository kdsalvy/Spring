package learn.spring.springdemo.xmlconfig.practice;

import learn.spring.springdemo.xmlconfig.Coach;
import learn.spring.springdemo.xmlconfig.FortuneService;

public class CricketCoach implements Coach {

    private FortuneService fortuneService;
    private String emailAddress;
    private String team;

    public CricketCoach() {
        System.out.println("CricketCoach.CricketCoach()");
    }

    @Override
    public String getDailyWorkout() {
        return "Do bowling practice";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("CricketCoach.setFortuneService()");
        this.fortuneService = fortuneService;
    }

    public void setEmailAddress(String emailAddress) {
        System.out.println("CricketCoach.setEmailAddress()");
        this.emailAddress = emailAddress;
    }

    public void setTeam(String team) {
        System.out.println("CricketCoach.setTeam()");
        this.team = team;
    }

    @Override
    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String getTeam() {
        return team;
    }

}
