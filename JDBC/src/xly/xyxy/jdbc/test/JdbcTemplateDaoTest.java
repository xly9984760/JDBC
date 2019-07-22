package xly.xyxy.jdbc.test;

import xly.xyxy.jdbc.Dao.impl.NovelJdbcTemplateDaoImpl;

/**
 * @BelongsProject: test
 * @BelongsPackage: xly.xyxy.jdbc.test
 * @Author: 99847
 * @CreateTime: 2019-07-22 12:46
 * @Description: 实体类测试
 */
public class JdbcTemplateDaoTest {
    public static void main(String[] args) {
        NovelJdbcTemplateDaoImpl dao = new NovelJdbcTemplateDaoImpl();
        System.out.println(dao.getAll("select * from novel"));
        System.out.println(dao.update("insert into novel values(null,?,?)","测试","测试"));
        System.out.println(dao.getAll("select * from novel"));
        System.out.println(dao.getValue("select count(name) from novel"));

    }
}
