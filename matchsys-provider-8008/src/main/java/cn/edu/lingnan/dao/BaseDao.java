package cn.edu.lingnan.dao;


import cn.edu.lingnan.util.MySqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BaseDao<T> {

    /**
     * 新增数据
     *
     * @param bean 实例对象
     * @return 影响行数
     */
    @InsertProvider(type = MySqlProvider.class, method = MySqlProvider.INSERT)
    int insert(T bean);

    @DeleteProvider(type = MySqlProvider.class, method = MySqlProvider.DELETE)
    int delete(@Param("table") String table, @Param("where") String where);

    @UpdateProvider(type = MySqlProvider.class, method = MySqlProvider.UPDATE)
    int update(T bean);
}
