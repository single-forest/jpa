### Spring data jpa

#### SimpleJpaRepository

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


