package com.example.jpa.repository;

import com.example.jpa.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Long> {

    // 根据 emailAddress 和 lastname 字段 and 查询
    List<Person> findByEmailAddressAndLastname(String emailAddress,String lastname);
    // 根据 lastname 和 firstname 字段 or 查询忽略大小写,包含 distinct 去重,
    List<Person> findDistinctByLastnameOrFirstname(String lastname,String firstname);
    // 根据 lastname 字段查询忽略大小写
    List<Person> findByLastnameIgnoreCase(String lastname);
    // 根据 lastname 和 firstname 字段 and 查询忽略大小写
    List<Person> findByLastnameAndFirstnameAllIgnoreCase(String lastname,String firstname);
    // 根据 lastname 查询, 并将结果根据 firstname 排序, 正序
    List<Person> findByLastnameOrderByFirstnameAsc(String lastname);
    // 根据 lastname 查询, 并将结果根据 firstname 排序, 倒序
    List<Person> findByLastnameOrderByFirstnameDesc(String lastname);
}
