### Spring data jpa

#### Java Persistence API 介绍
   * 概念: 
   JPA 是 JDK 5.0 新增的协议，通过相关持久层注解（@Entity 里面的各种注解）来描述对象和关系型数据里面的表映射关系，并将 Java 项目运行
   期的实体对象，通过一种Session持久化到数据库中。

   * JPA 的内容分类
      * 以一套 API 标准定义了一系列接口，在 javax.persistence 的包下面，用来操作实体对象，执行 CRUD 操作，而实现的框架（Hibernate）
      替代我们完成所有的事情，让开发者从烦琐的 JDBC 和 SQL 代码中解脱出来，更加聚焦自己的业务代码，并且使架构师架构出来的代码更加可控。
      * 定义了一套基于对象的 SQL：Java Persistence Query Language（JPQL），像 Hibernate 一样，通过写面向对象（JPQL）而非面向数据
      库的查询语言（SQL）查询数据，避免了程序与数据库 SQL 语句耦合严重，比较适合跨数据源的场景。
      * ORM（Object/Relational Metadata）对象注解映射关系，JPA 直接通过注解的方式来表示 Java 的实体对象及元数据对象和数据表之间的
      映射关系，框架将实体对象与 Session 进行关联，通过操作 Session 中不通实体的状态，从而实现数据库的操作，并实现持久化到数据库表中
      的操作，与 DB 实现同步。
      
   * JPA 的开源实现
      JPA 的宗旨是为 POJO 提供持久化标准规范，可以集成在 Spring 的全家桶使用，也可以直接写独立 application 使用，任何用到 DB 操作的
      场景，都可以使用，极大地方便开发和测试，所以 JPA 的理念已经深入人心了。Spring Data JPA、Hibernate 3.2+、TopLink 10.1.3 以
      及 OpenJPA、QueryDSL 都是实现 JPA 协议的框架。
      
#### Spring Data 认识
   * 介绍:
      * Spring Data 项目是从 2010 年开发发展起来的，利用一个大家熟悉的、一致的、基于“注解”的数据访问编程模型，做一些公共操作的封装，
      可以轻松地让开发者使用数据库访问技术，包括关系数据库、非关系数据库（NoSQL）。同时又有不同的数据框架的实现，保留了每个底层数据存储
      结构的特殊特性。
      * Spring Data Common 是 Spring Data 所有模块的公共部分，该项目提供了基于 Spring 的共享基础设施，它提供了基于 repository 接
      口以 DB 操作的一些封装，以及一个坚持在 Java 实体类上标注元数据的模型。
      * Spring Data 不仅对传统的数据库访问技术如 JDBC、Hibernate、JDO、TopLick、JPA、MyBatis 做了很好的支持和扩展、抽象、提供方便
      的操作方法，还对 MongoDb、KeyValue、Redis、LDAP、Cassandra 等非关系数据的 NoSQL 做了不同的实现版本，方便开发者触类旁通。
      > 其实这种接口型的编程模式可以让我们很好地学习 Java 的封装思想，实现对操作的进一步抽象，我们也可以把这种思想运用在自己公司
        写的 Framework 上面。
   
   * Spring Data 的子项目
      主要项目（Main Modules）：
      * Spring Data Commons，定义了一套抽象的接口
      
      * Spring Data Gemfire
      
      * Spring Data JPA，关注的重点，对 Spring Data Common 的接口的 JPA 协议的实现
      
      * Spring Data KeyValue
      
      * Spring Data LDAP
      
      * Spring Data MongoDB
      
      * Spring Data REST
      
      * Spring Data Redis
      
      * Spring Data for Apache Cassandra
      
      * Spring Data for Apache Solr
      
      社区支持的项目（Community Modules）：
      
      * Spring Data Aerospike
      
      * Spring Data Couchbase
      
      * Spring Data DynamoDB
      
      * Spring Data Elasticsearch
      
      * Spring Data Hazelcast
      
      * Spring Data Jest
      
      * Spring Data Neo4j
      
      * Spring Data Vault
      
      其他（Related Modules）：
      
      * Spring Data JDBC Extensions
      
      * Spring for Apache Hadoop
      
      * Spring Content
      
#### Spring Data Common
   Spring Data 对整个数据操作做了很好的封装，其中 Spring Data Common 定义了很多公用的接口和一些相对数据操作的公共实现（如分页排序、
   结果映射、Autiting(审计) 信息、事务等），而 Spring Data JPA 就是 Spring Data Common 的关系数据库的查询实现。
   
   * Repository: Spring Data Common 的核心内容
      * CrudRepository
      * PageingAndSortingRepository
      * JpaRepository
   
   * Repository 接口是 Spring Data Common 里面的顶级父类接口，操作 DB 的入口类。
     Repository 是 Spring Data 里面进行数据库操作顶级的抽象接口，没有任何方法，Spring 将其作为 DAO 操作的 Type标记，任何接口继承
     它，就能成为一个 Repository，还可以实现 JPA 的一些默认实现方法。Spring 在做动态代理的时候，只要是 Repository 的子类或者实现类，
     再利用 T 类以及 T 类的 主键 ID 类型作为泛型的类型参数，就可以来标记出来、并捕获到要使用的实体类型，就能帮助使用者进行数据库操作。
     
   * Repository 类层次关系，分为以下 4 个大类
      * ReactiveCrudRepository 支持当前 NoSQL 方面的操作，目前 Reactive 主要有 Cassandra、MongoDB、Redis 的实现
      * RxJava2CrudRepository 支持 RxJava 2 做的标准响应式编程的接口
      * CoroutineCrudRepository 支持 Kotlin 语法的实现
      * CrudRepository 支持 JPA 相关的操作接口
   
   * 七大 Repository 接口：
      * Repository(org.springframework.data.repository)，标记类为 Repository 类，操作 DB 的入口；
      * CrudRepository(org.springframework.data.repository)，简单的 Curd 方法；
      * PagingAndSortingRepository(org.springframework.data.repository)，分页和排序支持；
      * QueryByExampleExecutor(org.springframework.data.repository.query)，简单 Example 查询；
      * JpaRepository(org.springframework.data.jpa.repository)，JPA 的扩展方法；
      * JpaSpecificationExecutor(org.springframework.data.jpa.repository)，JpaSpecification 扩展查询；
      * QueryDslPredicateExecutor(org.springframework.data.querydsl)，QueryDsl 的封装。
      
   * 两大 Repository 实现类:
      * SimpleJpaRepository(org.springframework.data.jpa.repository.support)，JPA 所有接口的默认实现类；
      * QueryDslJpaRepository(org.springframework.data.jpa.repository.support)，QueryDsl(Domain Specified Language) 的实现类。
      
   * CrudRepository 接口: 主要提供了增删改查方法
      * count(): long 查询总数返回 long 类型；
      * void delete(T entity) 根据 entity 进行删除；
      * void deleteAll(Iterable<? extends T> entities) 批量删除；
      * void deleteAll() 删除所有；
      * void deleteById(ID id); 根据主键删除，其是先查询出来再进行删除；
      * boolean existsById(ID id) 根据主键判断实体是否存在；
      * Iterable<T> findAllById(Iterable ids); 根据主键列表查询实体列表；
      * Iterable<T> findAll(); 查询实体的所有列表；
      * Optional<T> findById(ID id); 根据主键查询实体，返回 JDK 1.8 的 Optional，这可以避免 null exception；
      * <S extends T> S save(S entity); 保存实体方法，参数和返回结果可以是实体的子类；
      * saveAll(Iterable<S> entities) : 批量保存，原理和 save方法相同，通过 for 循环调用 save 方法实现。
   
   * PagingAndSortingRepository 接口: 提供分页和排序方法
      * Iterable<T> findAll(Sort sort); 根据排序参数，实现不同的排序规则获取所有的对象的集合
      * Page<T> findAll(Pageable pageable); 根据分页和排序进行查询，并用 Page 对返回结果进行封装。Pageable 对象封装了 Page 和 Sort
      
   * JpaRepository 接口:  JpaRepository 是 spring data 对关系型数据库进行抽象封装,它继承 PagingAndSortingRepository 类，并且其
   实现类也是 SimpleJpaRepository。JpaRepository 还继承和拥有了 QueryByExampleExecutor 的相关方法。
  
   * SimpleJpaRepository 实现类
       SimpleJpaRepository 作为 spring data jpa 针对关系型数据库的主要实现,主要存在如下属性:
       * EntityManager: 作为entity管理器,和持久化上下文(persistence context)关联,主要功能如下:
          * 管理当前持久化上下文中entity
          * 控制entity的查询(无锁查询,乐观锁查询,悲观锁查询)
          * 将entity数据持久化到数据库(flush)
          * 设置数据持久化模式(FlushMode)
          * entity锁定(lock)
          * entity刷新(refresh数据库数据)
          * 创建查询
            * 查询语句查询(qlString)
            * 标注查询(CriteriaQuery)
            * 更新查询(CriteriaUpdate)
            * 删除查询CriteriaDelete
            * 命名查询(nameQuery)
            * 存储过程查询(StoredProcedureQuery)
            * 本地查询(NativeQuery)
          * 绑定事务(joinTransaction)
          * 元模型获取(getMetamodel)
          * 实体图的管理(EntityGraphs)
       * entityInformation: 存储实体的相关信息和 Crud 方法的元数据

#### Defining Query Methods 的命名语法与参数
   Spring Data JPA 的最大特色是利用方法名定义查询方法（Defining Query Methods）DQM 来做 CRUD 操作。
   * DQM 两种语法如下:
       * 一种是直接通过方法名实现；
       * 另一种是 @Query 手动在方法上定义。
   * 方法的查询策略设置
   
   


