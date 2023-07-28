package com.example.test.service;

import com.example.test.repository.UserRepository;
import com.example.test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> fetchUserList() {
        return (List<User>)
                userRepository.findAll(Sort.by("lastname"));
    }
    public User getId(int id)
    {
        Optional<User> optional = userRepository.findById(id);
        User user = null;
        if(optional.isPresent())
        {
            user = optional.get();
            return user;
        } else {
            throw new RuntimeException(
                    "User not found by id" + id);
        }
    }

    @Override
    public void DeleteId(int id) {
        userRepository.deleteById(id);
    }

    public User addUser(User user)
    {
        return userRepository.save(user);
    }
}
