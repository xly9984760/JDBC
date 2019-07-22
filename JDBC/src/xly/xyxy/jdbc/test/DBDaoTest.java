package xly.xyxy.jdbc.test;

import xly.xyxy.jdbc.Dao.impl.NovelJdbcTemplateDaoImpl;

/**
 * @BelongsProject: test
 * @BelongsPackage: xly.xyxy.jdbc.test
 * @Author: 99847
 * @CreateTime: 2019-07-22 13:13
 * @Description: DButils测试
 */
public class DBDaoTest {
    public static void main(String[] args) {
        NovelJdbcTemplateDaoImpl dao = new NovelJdbcTemplateDaoImpl();
        System.out.println(dao.getAll("select * from novel"));
        System.out.println(dao.update("insert into novel values(null,?,?)","测试","测试"));
        System.out.println(dao.update("delete from novel where name=?","测试"));
        System.out.println(dao.getAll("select * from novel"));
        System.out.println(dao.getValue("select id from novel where id=3"));
    }
}
