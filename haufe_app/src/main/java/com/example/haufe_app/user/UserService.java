package com.example.haufe_app.user;

import com.example.haufe_app.review.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private UserRepo userRepo;
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> allUsers() {
        List<User> users = new ArrayList<>();

        userRepo.findAll().forEach(users::add);

        return users;
    }
}
