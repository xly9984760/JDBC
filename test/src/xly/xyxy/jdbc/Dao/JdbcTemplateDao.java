package xly.xyxy.jdbc.Dao;

import java.util.List;

/**
 * @BelongsProject: test
 * @BelongsPackage: xly.xyxy.jdbc.Dao
 * @Author: xly
 * @CreateTime: 2019-07-22 10:09
 * @Description: 通过jdbcTemplate完成持久层的编写
 */
public interface JdbcTemplateDao<T> {
    Integer update(String sql, Object... args);

    T get(String sql, Object... args);

    List<T> getAll(String sql, Object... args);

    Integer getValue(String sql, Object... args);

}
