package com.example.jpa.test;

import com.example.jpa.model.User;
import com.example.jpa.repository.UserCrudRepository;
import com.example.jpa.repository.UserPagingAndSortingRepository;
import com.example.jpa.repository.UserRepository;
import com.example.jpa.repository.UserTagRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

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

    @Autowired
    private UserPagingAndSortingRepository userPagingAndSortingRepository;

    @BeforeEach
    public void before(){
        userRepository.save(User.builder().name("jackA").email("A654321@126.com").build());
        userRepository.save(User.builder().name("jackB").email("B321654@126.com").build());
        userRepository.save(User.builder().name("jackC").email("C321654@126.com").build());
        userRepository.save(User.builder().name("jackD").email("D321654@126.com").build());
        userRepository.save(User.builder().name("jackE").email("E321654@126.com").build());
    }

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
        List<User> jacks = userTagRepository.findByName("jack");
        System.out.println(jacks);
        List<User> jack = userTagRepository.findByEmailAndName("321654@126.com", "jack");
        System.out.println(jack);
    }

    @Test
    public void testCrudRepository(){
        long count = userCrudRepository.count();
        System.out.println(count);
        Optional<User> one = userRepository.findOne(Example.of(User.builder().id(1L).build()));
        one.ifPresent(System.out::println);
    }

    @Test
    public void testPagingAndSortingRepository(){
        Sort sort = Sort.by(Sort.Order.desc("name"));
        Iterable<User> allBySort = userPagingAndSortingRepository.findAll(sort);
        System.out.println(allBySort);

        Page<User> page = userPagingAndSortingRepository
                .findAll(PageRequest.of(0, 20, Sort.by(Sort.Order.asc("name"))));
        System.out.println(page.getContent());
    }
}
