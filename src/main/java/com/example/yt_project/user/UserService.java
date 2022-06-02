package com.example.yt_project.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void addUser(User user) {
        List<User> userFromDb = userRepository.getUserByUsername(user.getUsername());
        if(!userFromDb.isEmpty()){
            throw new IllegalStateException("Username already taken");
        }
        userRepository.save(user);
    }
}
