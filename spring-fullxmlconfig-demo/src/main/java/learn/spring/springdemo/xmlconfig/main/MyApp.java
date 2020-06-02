package learn.spring.springdemo.xmlconfig.main;

import learn.spring.springdemo.xmlconfig.BaseballCoach;
import learn.spring.springdemo.xmlconfig.Coach;
import learn.spring.springdemo.xmlconfig.TrackCoach;

public class MyApp {

    public static void main(String[] args) {
        Coach baseballCoach = new BaseballCoach();
        System.out.println(baseballCoach.getDailyWorkout());
        
        Coach trackCoach = new TrackCoach();
        System.out.println(trackCoach.getDailyWorkout());
    }

}
