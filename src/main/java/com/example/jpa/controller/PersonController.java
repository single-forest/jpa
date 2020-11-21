package com.example.jpa.controller;

import com.example.jpa.model.Person;
import com.example.jpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    /**
     * 批量新增
     * @param persons
     * @return
     */
    @PostMapping(path = "/persons",consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> addNewPersons(@RequestBody List<Person> persons){
        return personRepository.saveAll(persons);
    }

    /**
     * 根据 emailAddress 及 lastname 查询
     * @param emailAddress
     * @param lastname
     * @return
     */
    @GetMapping(path = "/getPersonsByLastnameAndFirstname")
    @ResponseBody
    public List<Person> getPersonsByLastnameAndFirstname(
            @RequestParam("emailAddress")String emailAddress,@RequestParam("lastname")String lastname){
        return personRepository.findByEmailAddressAndLastname(emailAddress,lastname);
    }

}
