package com.example.demoSpringDataJPAH2Rest.service;

import com.example.demoSpringDataJPAH2Rest.exception.UserNotFoundException;
import com.example.demoSpringDataJPAH2Rest.model.User;
import com.example.demoSpringDataJPAH2Rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> getUser(Long id){
        return userRepository.findById(id);
    }

    public User updateUser(Long id, User userDetails){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setAge(userDetails.getAge());
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }


}
