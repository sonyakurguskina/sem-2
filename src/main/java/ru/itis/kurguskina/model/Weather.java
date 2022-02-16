package ru.itis.kurguskina.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Weather {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String description;
    private String humidity;
    private String temp;
    private String city;
    private String email;

    public Weather(Integer id, String description, String humidity, String temp, String city, String email) {
        this.id = id;
        this.description = description;
        this.humidity = humidity;
        this.temp = temp;
        this.city = city;
        this.email = email;
    }

    public Weather() {

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getTemp() {
        return temp;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }
}
