package xly.xyxy.jdbc.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @BelongsProject: test
 * @BelongsPackage: xly.xyxy.jdbc.utils
 * @Author: 99847
 * @CreateTime: 2019-07-22 09:53
 * @Description: 使用Druid的工具类
 */
public class DruidJDBCUtils {
    private static DataSource ds;

    static {
        /**
        * @Description: 通过静态代码块 完成加载配置文件（druid配置文件不要求特定名称），
         * 获取DataSource的操作，获取连接与关闭连接都是通过连接池完成
        * @author: 99847
        * @date: 2019/7/22 10:06
        * @param: * @param null
        * @return:
        */
        Properties pro = new Properties();
        try {
            pro.load(DruidJDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void close(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public static void close(PreparedStatement ps, Connection conn) throws SQLException {
        close(null, ps, conn);
    }

    public static DataSource getDataSource() {
        return ds;
    }
}
