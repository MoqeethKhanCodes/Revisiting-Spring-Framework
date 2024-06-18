package com.moqeeth.restControllerTest.springBoot.service;

import com.moqeeth.restControllerTest.springBoot.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> userList;

    public UserService() {
        userList = new ArrayList<>();

        User user1 = new User(1, "Ahmed", 20, "ahmed@mail.com");
        User user2 = new User(2, "Abdul", 21, "abdul@mail.com");
        User user3 = new User(3, "Moqeeth", 23, "moqeeth@mail.com");
        User user4 = new User(4, "Khan", 24, "khan@mail.com");
        User user5 = new User(5, "Mohammed", 26, "mohammed@mail.com");

        userList.addAll(Arrays.asList(user1, user2, user3, user4, user5));


    }

    //ConciseFormat of getUser1
    public Optional<User> getUser(Integer id) {
        return userList.stream()
                .filter(user -> id.equals(user.getId()))
                .findFirst();
    }


    public Optional<User> getUser1(Integer id) {
        Optional optional = Optional.empty();
        for (User user : userList) {
            if (id == user.getId()) {
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;
    }
}
