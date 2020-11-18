package com.example.jpa.repository;

import com.example.jpa.model.User;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Repository 标记 DB 入口示例
 * 不提供任何默认实现,需要自己写查询方法,支持 defining name query
 */
public interface UserTagRepository extends Repository<User,Long> {

    List<User> findByEmailAndName(String email,String name);

    List<User> findByName(String name);
}
