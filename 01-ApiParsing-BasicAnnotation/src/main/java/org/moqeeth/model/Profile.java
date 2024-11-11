package org.moqeeth.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Profile {

    @JsonProperty("name")
    private String myName;

    @JsonProperty("age")
    private double myAge;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("dateOfBirth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dob;

    public String getMyName() {
        return myName;
    }

    public double getMyAge() {
        return myAge;
    }

    public String getGender() {
        return gender;
    }

    public Date getDob() {
        return dob;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "dob=" + dob +
                ", myName='" + myName + '\'' +
                ", myAge=" + myAge +
                ", gender='" + gender + '\'' +
                '}';
    }
}
