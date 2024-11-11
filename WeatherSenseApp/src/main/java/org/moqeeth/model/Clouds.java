package org.moqeeth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Clouds {
    private int all;

    @Override
    public String toString() {
        return "Clouds{" +
                "all=" + all +
                '}';
    }

}
