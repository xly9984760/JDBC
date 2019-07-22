package xly.xyxy.jdbc.test;

import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import xly.xyxy.jdbc.domain.Novel;
import xly.xyxy.jdbc.utils.DruidJDBCUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * @BelongsProject: test
 * @BelongsPackage: xly.xyxy.jdbc.test
 * @Author: 99847
 * @CreateTime: 2019-07-22 10:43
 * @Description: 测试Druid
 */
public class DruidDemo {
    @Test
    public void test1() {
        /**
         * @Description: 测试单个连接操作
         * @author: 99847
         * @date: 2019/7/22 10:44
         * @param: * @param
         * @return:void
         */
        try {
            System.out.println(DruidJDBCUtils.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test02() {
        /**
         * @Description: 测试多个连接操作
         * @author: 99847
         * @date: 2019/7/22 10:49
         * @param: * @param
         * @return:void
         */
        for (int i = 1; i <= 10; i++) {
            try {
                System.out.println("第" + i + "次连接:" + DruidJDBCUtils.getConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void get() {
        /**
         * @Description: 利用JdbTemolate查询一行数据(利用此方法查询多行数据将会报错)
         * 并且装入Map中
         * @author: 99847
         * @date: 2019/7/22 10:59
         * @param: * @param
         * @return:void
         */
        JdbcTemplate template = new JdbcTemplate(DruidJDBCUtils.getDataSource());
        String sql = "select * from novel where id =?";
        System.out.println(template.queryForMap(sql, 2));
    }

    @Test
    public void test04() {
        /**
         * @Description: 利用JdbTemolate查询多行数据
         * 并且每一行数据分别装入Map中，再添加到List集合中
         * @author: 99847
         * @date: 2019/7/22 10:59
         * @param: * @param
         * @return:void
         */
        JdbcTemplate template = new JdbcTemplate(DruidJDBCUtils.getDataSource());
        String sql = "select * from novel";
        System.out.println(template.queryForList(sql));
    }

    @Test
    public void test05() {
        /**
         * @Description: 利用JdbcTemplate插入一行新的数据
         * @author: 99847
         * @date: 2019/7/22 11:08
         * @param: * @param
         * @return:void
         */
        JdbcTemplate template = new JdbcTemplate(DruidJDBCUtils.getDataSource());
        String sql = "insert into novel values (null,?,?)";
        System.out.println(template.update(sql, "绝世武神", "净无痕"));
    }

    @Test
    public void test06() {
        /**
         * @Description: 利用此方法，可以更改数据
         * @author: 99847
         * @date: 2019/7/22 11:10
         * @param: * @param
         * @return:void
         */
        JdbcTemplate template = new JdbcTemplate(DruidJDBCUtils.getDataSource());
        String sql = "update novel set author=?";
        System.out.println(template.update(sql, "我欲封天"));
    }

    @Test
    public void test07() {
        /**
         * @Description: 删除一行数据
         * @author: 99847
         * @date: 2019/7/22 11:17
         * @param: * @param
         * @return:void
         */
        JdbcTemplate template = new JdbcTemplate(DruidJDBCUtils.getDataSource());
        String sql = "delete from novel where id=?";
        System.out.println(template.update(sql, 1));
    }

    @Test
    public void test08() {
        /**
         * @Description: 查询所有数据并且封装到实体类中
         * @author: 99847
         * @date: 2019/7/22 11:25
         * @param: * @param
         * @return:void
         */
        JdbcTemplate template = new JdbcTemplate(DruidJDBCUtils.getDataSource());
        String sql = "select * from novel";
        List<Novel> list = template.query(sql, new BeanPropertyRowMapper<Novel>(Novel.class));
        for (Novel emp : list) {
            System.out.println(emp);
        }
    }

    @Test
    public void test09() {
        /**
         * @Description: queryForObject一般用于聚合函数
         * @author: 99847
         * @date: 2019/7/22 11:24
         * @param: * @param
         * @return:void
         */
        JdbcTemplate template = new JdbcTemplate(DruidJDBCUtils.getDataSource());
        String sql = "select count(id) from novel";
        System.out.println(template.queryForObject(sql, Long.class));
    }
    @Test
    public void test10() {
        /**
        * @Description: 查询单个字段的值
        * @author: 99847
        * @date: 2019/7/22 11:50
        * @param: * @param
        * @return:void
        */
        JdbcTemplate template = new JdbcTemplate(DruidJDBCUtils.getDataSource());
        String sql = "select name from novel where id =?";
        System.out.println(template.queryForObject(sql,String.class,3));
    }
}
