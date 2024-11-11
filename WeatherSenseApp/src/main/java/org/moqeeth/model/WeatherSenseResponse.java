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

