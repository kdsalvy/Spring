package learn.spring.springdemo.xmlconfig;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    public TrackCoach() {
    }

    public TrackCoach(FortuneService fortuneService) {
        super();
        this.fortuneService = fortuneService;
    }

    public String getDailyWorkout() {
        return "Run hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return "Just do it: " + fortuneService.getFortune();
    }

    @Override
    public String getEmailAddress() {
        return null;
    }

    @Override
    public String getTeam() {
        return null;
    }

    public void customInitMethod() {
        System.out.println("TrackCoach.customInitMethod()");
    }

    public void customDestroyMethod() {
        System.out.println("TrackCoach.customDestroyMethod()");
    }
}
