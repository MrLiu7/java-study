package DataSource.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author 柳继纪
 * @date 14/5/2022
 * @apiNote
 */
public class JDBCDruidUtils {
    //数据库连接池
    private static final DataSource dataSource;

    static {
        Properties properties = new Properties();
        InputStream resourceAsStream = JDBCDruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "数据库连接失败！", "数据库连接错误", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
        try {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "数据库连接池连接失败！", "连接池连接错误", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取数据库连接对象
     * @return 返回一个数据库连接对象
     * @throws SQLException 抛出异常
     */
    public static Connection createConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * 归还数据库连接对象
     * @param connections 传入需要被归还的连接对象
     * @throws SQLException 抛出异常
     */
    public static void closeConnection(Connection...connections) throws SQLException {
        for (Connection connection : connections) {
            connection.close();
        }
    }

    /**
     * 归还数据库连接对象
     * @param connections 传入需要被归还的连接对象
     * @throws SQLException 抛出异常
     */
    public static void closeConnection(PreparedStatement preparedStatement,Connection...connections) throws SQLException {
        preparedStatement.close();
        for (Connection connection : connections) {
            connection.close();
        }
    }

    /**
     * 获取连接池的方法
     * @return 返回一个新的数据库连接池
     * @throws Exception 抛出异常
     */
    public static DataSource getDataSource() throws Exception {
        Properties properties = new Properties();
        InputStream resourceAsStream = JDBCDruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(resourceAsStream);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        return dataSource;
    }
}
