package org.moqeeth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

    private String name;
    private double age;
    private Date dateOfBirth;
}
