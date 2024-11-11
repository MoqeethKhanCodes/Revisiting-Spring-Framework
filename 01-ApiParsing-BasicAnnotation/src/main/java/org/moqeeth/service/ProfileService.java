package org.moqeeth.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.moqeeth.model.Profile;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Slf4j
@Service
public class ProfileService {

    public void getProfile() throws IOException {
        File file = new File("C:\\Developer\\Resource\\ApiParsingResources\\ProfilejsonText1.txt");

        ObjectMapper objectMapper = new ObjectMapper();

        Profile profile = objectMapper.readValue(file, Profile.class);

        log.info("My Profile : {}", profile);
    }

    public String sendProfile() throws IOException {
        String jsonData = "{\n" +
                "\t\"name\" : \"Khan\",\n" +
                "\t\"age\" : 20.5,\n" +
                "\t\"dateOfBirth\" : \"2000-12-05\"\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();

        Profile profile = objectMapper.readValue(jsonData, Profile.class);

        return objectMapper.writeValueAsString(profile);

    }
}
