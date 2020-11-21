package com.example.jpa.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.Optional;

/**
 * 自定义 BaseRepository 实现基本 Repository 定制
 * {@link @NoRepositoryBean} 因为这个类只是用来继承,无直接功能,所以标注此注解,
 * 意在通知 Spring 管理 Repository 的子接口时,不要给此接口创建代理实现
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface MyBaseRepository<T, ID extends Serializable> extends Repository<T,ID> {
    Optional<T> findById(ID id);
    T save(T entity);
}
