package xly.xyxy.jdbc.Dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.jdbc.core.JdbcTemplate;
import sjxy.reflect.ReflectionUtils;
import xly.xyxy.jdbc.Dao.DBDao;
import xly.xyxy.jdbc.utils.DruidJDBCUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * @BelongsProject: test
 * @BelongsPackage: xly.xyxy.jdbc.Dao.impl
 * @Author: 99847
 * @CreateTime: 2019-07-22 12:52
 * @Description: DBDao实现类
 */
public class DBDaoImpl<T> implements DBDao<T> {
    private QueryRunner qr;
    private Class<T> type;

    public DBDaoImpl() {
        qr = new QueryRunner(DruidJDBCUtils.getDataSource());
        type = ReflectionUtils.getSuperGenericType(this.getClass());
    }

    @Override
    public int update(String sql, Object... args) throws SQLException {
        return  qr.update(sql, args);
    }

    @Override
    public T get(String sql, Object... args) throws SQLException {
        return qr.query(sql, new BeanHandler<>(type), args);
    }

    @Override
    public List<T> getAll(String sql, Object... args) throws SQLException {
        return qr.query(sql,new BeanListHandler<>(type), args);
    }

    @Override
    public Object getValue(String sql, Object... args) throws SQLException {
        return qr.query(sql,new ScalarHandler<>(1),args);
    }
}
