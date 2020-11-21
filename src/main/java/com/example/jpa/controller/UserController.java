package com.example.jpa.controller;

import com.example.jpa.model.User;
import com.example.jpa.repository.MyUserRepository;
import com.example.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MyUserRepository myUserRepository;

    /**
     * 保存用户
     * @param user
     * @return
     */
    @PostMapping(path = "/user",consumes = MediaType.APPLICATION_JSON_VALUE)
    public User addNewUser(@RequestBody User user){
        return userRepository.save(user);
    }

    /**
     * 分页查询用户列表
     * @param request
     * @return
     */
    @GetMapping(path = "/users")
    @ResponseBody
    public Page<User> getAllUsers(Pageable request){
        return userRepository.findAll(request);
    }

    @GetMapping(path = "/my/users")
    @ResponseBody
    public User getMyUsers(@RequestParam("id")Long id){
        return myUserRepository.findById(id).orElse(null);
    }
}
