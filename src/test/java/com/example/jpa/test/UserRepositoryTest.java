package com.example.jpa.test;

import com.example.jpa.model.User;
import com.example.jpa.repository.UserCrudRepository;
import com.example.jpa.repository.UserRepository;
import com.example.jpa.repository.UserTagRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Example;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTagRepository userTagRepository;

    @Autowired
    private UserCrudRepository userCrudRepository;

    @Test
    public void testSaveUser(){
        User user = userRepository.save(User.builder().name("jackxx").email("654321@126.com").build());
        Assert.assertNotNull(user);
        List<User> users = userRepository.findAll();
        System.out.println(users);
        Assert.assertNotNull(users);
    }

    @Test
    public void testRepositoryTag(){
        User user = userRepository.save(User.builder().name("jack").email("321654@126.com").build());
        Assert.assertNotNull(user);
        List<User> jacks = userTagRepository.findByName("jack");
        System.out.println(jacks);
        List<User> jack = userTagRepository.findByEmailAndName("321654@126.com", "jack");
        System.out.println(jack);
    }

    @Test
    public void testCrudRepository(){
        User user = userRepository.save(User.builder().name("jack").email("321654@126.com").build());
        Assert.assertNotNull(user);
        long count = userCrudRepository.count();
        System.out.println(count);
        Optional<User> one = userRepository.findOne(Example.of(new User()));
        one.ifPresent(System.out::println);
    }
}
