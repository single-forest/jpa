package com.example.jpa.controller;

import com.example.jpa.model.Person;
import com.example.jpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
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

    @GetMapping(path = "/findDistinctByLastnameOrFirstname")
    @ResponseBody
    public List<Person> findDistinctByLastnameOrFirstname(
            @RequestParam("lastname")String lastname,@RequestParam("firstname")String firstname){
        return personRepository.findDistinctByLastnameOrFirstname(lastname,firstname);
    }

    @GetMapping(path = "/findByLastnameIgnoreCase")
    @ResponseBody
    public List<Person> findByLastnameIgnoreCase(@RequestParam("lastname")String lastname){
        return personRepository.findByLastnameIgnoreCase(lastname);
    }

    @GetMapping(path = "/findByLastnameAndFirstnameAllIgnoreCase")
    @ResponseBody
    public List<Person> findByLastnameAndFirstnameAllIgnoreCase(
            @RequestParam("lastname")String lastname,@RequestParam("firstname")String firstname){
        return personRepository.findByLastnameAndFirstnameAllIgnoreCase(lastname,firstname);
    }

    @GetMapping(path = "/findByLastnameOrderByFirstnameAsc")
    @ResponseBody
    public List<Person> findByLastnameOrderByFirstnameAsc(@RequestParam("lastname")String lastname){
        return personRepository.findByLastnameStartingWithOrderByFirstnameAsc(lastname);
    }

    @GetMapping(path = "/findByLastnameOrderByFirstnameDesc")
    @ResponseBody
    public List<Person> findByLastnameOrderByFirstnameDesc(@RequestParam("lastname")String lastname){
        return personRepository.findByLastnameEndingWithOrderByFirstnameDesc(lastname);
    }

    @GetMapping(path = "/findPageByLastname")
    public Page<Person> findPageByLastname(@RequestParam("lastname")String lastname){
        // 注意，jpa 的页码从 0 开始
        return personRepository.findPageByLastnameStartingWith(lastname, PageRequest.of(0,10));
    }

    @GetMapping(path = "/findSliceByLastname")
    public Slice<Person> findSliceByLastname(@RequestParam("lastname")String lastname){
        return personRepository.findSliceByLastnameStartingWith(lastname,PageRequest.of(1,3));
    }

    @GetMapping(path = "/findListByLastnameDesc")
    public List<Person> findListByLastnameDesc(@RequestParam("lastname")String lastname){
        return personRepository.findListByLastnameStartingWith(lastname, Sort.by(Sort.Direction.DESC,"lastname"));
    }

    @GetMapping(path = "/findListByLastname")
    public List<Person> findListByLastname(@RequestParam("lastname")String lastname){
        return personRepository.findListByLastnameStartingWith(lastname,PageRequest.of(0,3,Sort.Direction.ASC,"firstname"));
    }

}
