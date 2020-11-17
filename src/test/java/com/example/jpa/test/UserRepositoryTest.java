package com.example.jpa.test;

import com.example.jpa.model.User;
import com.example.jpa.repository.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser(){
        User user = userRepository.save(User.builder().name("jackxx").email("654321@126.com").build());
        Assert.assertNotNull(user);
        List<User> users = userRepository.findAll();
        System.out.println(users);
        Assert.assertNotNull(users);
    }
}
