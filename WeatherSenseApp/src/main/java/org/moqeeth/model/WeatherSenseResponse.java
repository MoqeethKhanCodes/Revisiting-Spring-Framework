package org.moqeeth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherSenseResponse {
    private Coord coord;
    private List<Weather> weather;
    private Main main;
    private Wind wind;
    private Clouds clouds;
    private Sys sys;
    private String name;

    @Override
    public String toString() {
        return "WeatherSenseResponse{" +
                "coord=" + coord +
                ", weather=" + weather +
                ", main=" + main +
                ", wind=" + wind +
                ", clouds=" + clouds +
                ", sys=" + sys +
                ", name='" + name + '\'' +
                '}';
    }

}

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
class Coord {
    private double lon;
    private double lat;

    @Override
    public String toString() {
        return "Coord{" +
                "lon=" + lon +
                ", lat=" + lat +
                '}';
    }

}

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
class Weather {
    private String main;
    private String description;
    private String icon;

    @Override
    public String toString() {
        return "Weather{" +
                "main='" + main + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }

}

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
class Main {
    private double temp;
    private double feels_like;
    private int pressure;
    private int humidity;

    @Override
    public String toString() {
        return "Main{" +
                "temp=" + temp +
                ", feels_like=" + feels_like +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                '}';
    }

}

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
class Wind {
    private double speed;
    private int deg;

    @Override
    public String toString() {
        return "Wind{" +
                "speed=" + speed +
                ", deg=" + deg +
                '}';
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
class Clouds {
    private int all;

    @Override
    public String toString() {
        return "Clouds{" +
                "all=" + all +
                '}';
    }

}

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
class Sys {
    private String country;
    private long sunrise;
    private long sunset;

    @Override
    public String toString() {
        return "Sys{" +
                "country='" + country + '\'' +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                '}';
    }

}
