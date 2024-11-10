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
        File file = new File("C:\\Developer\\Resource\\ApiParsingResources\\ProfilejsonText.txt");

        ObjectMapper objectMapper = new ObjectMapper();

        Profile profile = objectMapper.readValue(file, Profile.class);

        log.info("My Profile : {}", profile);
    }
}
