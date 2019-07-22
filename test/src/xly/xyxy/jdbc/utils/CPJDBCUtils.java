package xly.xyxy.jdbc.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

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
 * @CreateTime: 2019-07-22 10:10
 * @Description: 使用c3p0的工具类
 */
public class CPJDBCUtils {
    /**
    * @Description: c3p0的配置文件有名称要求，
     * 所以会src下自动寻找相关的配置文件，不需要我们手动加载
    * @author: 99847
    * @date: 2019/7/22 10:38
    * @param: * @param null
    * @return:
    */
    private static DataSource ds = new ComboPooledDataSource();

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static DataSource getDataSource() {
        return ds;
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
}
