package learn.spring.springdemo.mvc;

import java.util.LinkedHashMap;
import java.util.Map;

public class Student {

    private String firstName;
    private String lastName;
    private String country;
    private String favouriteLanguage;
    private String[] favoriteOsList;
    private Map<String, String> countryMap;

    public Student() {
        countryMap = new LinkedHashMap<>();
        countryMap.put("BR", "Brazil");
        countryMap.put("FR", "France");
        countryMap.put("DE", "Germany");
        countryMap.put("IN", "India");
        countryMap.put("US", "United States");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Map<String, String> getCountryMap() {
        return countryMap;
    }

    public String getFavouriteLanguage() {
        return favouriteLanguage;
    }

    public void setFavouriteLanguage(String favouriteLanguage) {
        this.favouriteLanguage = favouriteLanguage;
    }

    public String[] getFavoriteOsList() {
        return favoriteOsList;
    }

    public void setFavoriteOsList(String[] favoriteOsList) {
        this.favoriteOsList = favoriteOsList;
    }
}
