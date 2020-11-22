package com.example.jpa.test;

import com.example.jpa.model.Person;
import com.example.jpa.repository.PersonRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testCountByLastname(){
        personRepository.save(Person.builder().lastname("loy1").build());
        long count = personRepository.countByLastname("loy1");
        Assert.assertEquals(count,1);
    }

    @Test
    public void testDeleteByLastname(){
        personRepository.save(Person.builder().lastname("loy4").build());
        long delete = personRepository.deleteByLastname("loy4");
        Assert.assertEquals(delete,1);
    }

    @Test
    public void testRemoveByLastname(){
        personRepository.save(Person.builder().lastname("loy2").build());
        List<Person> removedPerson = personRepository.removeByLastname("loy2");
        System.out.println(removedPerson);
        Assert.assertEquals(removedPerson.size(),1);
    }
}
