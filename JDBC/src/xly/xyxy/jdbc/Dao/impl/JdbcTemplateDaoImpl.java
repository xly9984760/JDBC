package xly.xyxy.jdbc.Dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import sjxy.reflect.ReflectionUtils;
import xly.xyxy.jdbc.Dao.JdbcTemplateDao;
import xly.xyxy.jdbc.utils.DruidJDBCUtils;

import java.util.List;

/**
 * @BelongsProject: test
 * @BelongsPackage: xly.xyxy.jdbc.Dao.impl
 * @Author: 99847
 * @CreateTime: 2019-07-22 12:04
 * @Description: JdbcTemplateDao实现类
 */
public class JdbcTemplateDaoImpl<T> implements JdbcTemplateDao<T> {
    private JdbcTemplate template;
    public Class<T> type;

    public JdbcTemplateDaoImpl() {
        template = new JdbcTemplate(DruidJDBCUtils.getDataSource());
        type = ReflectionUtils.getSuperGenericType(this.getClass());
    }

    @Override
    public Integer update(String sql, Object... args) {
        return template.update(sql, args);
    }

    @Override
    public T get(String sql, Object... args) {
        return (template.query(sql,new BeanPropertyRowMapper<>(type))).get(0);
    }

    @Override
    public List<T> getAll(String sql, Object... args) {
        return template.query(sql,new BeanPropertyRowMapper<>(type),args);
    }

    @Override
    public Integer getValue(String sql, Object... args) {
        return template.queryForObject(sql,Integer.class);
    }
}
