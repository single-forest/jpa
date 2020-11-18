package com.example.jpa.repository;

import com.example.jpa.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * CrudRepository 的默认实现 save 和 deleteById 中
 * 在进行 Update、Delete、Insert 等操作之前，会通过 findById 先查询一下实体对象的 ID，然后再去对查询出来的实体对象进行保存操作。
 * 在 Delete 的时候，查询到的对象不存在，则直接抛异常。
 *
 * 在 save 方法中，有个 entityInformation.isNew（entity）的判断，如果当传递的参数里面没有 ID，则直接 insert；
 * 若当传递的参数里面有 ID，则会触发 select 查询。此方法会去看一下数据库里面是否存在此记录，若存在，则 update，否则 insert。
 */
public interface UserCrudRepository extends CrudRepository<User,Long> {
}
