package com.example.jpa.repository;

import com.example.jpa.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Long> {

    // 根据 emailAddress 和 lastname 字段 and 查询
    List<Person> findByEmailAddressAndLastname(String emailAddress,String lastname);
    // 根据 lastname 和 firstname 字段 or 查询忽略大小写,包含 distinct 去重
    List<Person> findDistinctByLastnameOrFirstname(String lastname,String firstname);
    // 根据 lastname 字段查询忽略大小写
    List<Person> findByLastnameIgnoreCase(String lastname);
    // 根据 lastname 和 firstname 字段 and 查询忽略大小写
    List<Person> findByLastnameAndFirstnameAllIgnoreCase(String lastname,String firstname);
    // 根据 lastname 查询, 并将结果根据 firstname 排序, 正序
    List<Person> findByLastnameStartingWithOrderByFirstnameAsc(String lastname);
    // 根据 lastname 查询, 并将结果根据 firstname 排序, 倒序
    List<Person> findByLastnameEndingWithOrderByFirstnameDesc(String lastname);

    // 根据 lastname 查询匹配的数量
    long countByLastname(String lastname);
    // 根据 lastname 匹配删除数据
    long deleteByLastname(String lastname);
    //根据 lastname 匹配删除数据,并返回删除的User
    List<Person> removeByLastname(String lastname);

    //根据分页参数查询，返回一个带分页结果的 Page
    Page<Person> findPageByLastnameStartingWith(String lastname, Pageable pageable);
    //根据分页参数查询，返回一个片结果 Slice
    Slice<Person> findSliceByLastnameStartingWith(String lastname, Pageable pageable);
    //根据排序参数查询，返回一个集合结果 List
    List<Person> findListByLastnameStartingWith(String lastname, Sort sort);
    //根据分页参数查询，返回一个集合结果 List
    List<Person> findListByLastnameStartingWith(String lastname, Pageable pageable);

    // 获取根据 lastname 正序查询结果的第一条
    Person findFirstByOrderByLastnameAsc();
    // 获取根据 age 倒序查询结果的第一条
    Person findTopByOrderByAgeDesc();
    // 获取根据 lastname 查找的前三条，带去重，支持查询结果分页
    List<Person> findDistinctTop3ByLastname(String lastname, Pageable pageable);
    // 获取根据 lastname 查找的前十条，支持结果排序
    List<Person> findFirst10ByLastname(String lastname, Sort sort);
    // 获取根据 lastname 查找的前十条，支持结果分页
    List<Person> findTop10ByLastname(String lastname, Pageable pageable);

}
