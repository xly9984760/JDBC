package xly.xyxy.jdbc.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * @BelongsProject: test
 * @BelongsPackage: xly.xyxy.jdbc.Dao
 * @Author: xly
 * @CreateTime: 2019-07-22 12:51
 * @Description: 运用dbutils
 */
public interface DBDao<T> {
    int update(String sql, Object... args) throws SQLException;

    T get(String sql, Object... args) throws SQLException;

    List<T> getAll(String sql, Object... args) throws SQLException;

    Object getValue(String sql, Object... args) throws SQLException;
}
