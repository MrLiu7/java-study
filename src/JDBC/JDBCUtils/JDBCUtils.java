package JDBC.JDBCUtils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @author 柳继纪
 * @date 13/5/2022
 * @apiNote
 */
public class JDBCUtils {
    private static final String url;
    private static final String user;
    private static final String password;

    /**
     * 资源文件只需要读取一次，因此使用静态代码块
     * 静态代码块只能读取到静态的成员变量，静态的成员方法
     */
    static {
        //Properties配置文件类
        Properties properties = new Properties();

        //获取src路径的类 ClassLoader
        //当前 类.class.getClassLoader
        ClassLoader classLoader = JDBCUtils.class.getClassLoader();
        //获取想要的文件的资源定位符
        URL resource = classLoader.getResource("jdbc.properties");
        //通过资源定位符获取资源的路径
        assert resource != null;
        String path = resource.getPath();

        //加载文件
        //Reader 和 InputStream作为参数，此处使用Reader
        try {
            properties.load(new FileReader(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //获取资源
        url = properties.getProperty("url");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
    }

    /**
     * 创建连接数据库的对象
     *
     * @return 返回数据库连接对象
     */
    public static Connection creat() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }


    /**
     * 释放资源
     * 工具类只需要使用类名调用因此使用static修饰方法
     *
     * @param connection 数据库连接对象
     * @param statement  sql语句执行对象
     */
    public static void close(Connection connection, Statement statement) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 释放资源
     * 工具类只需要使用类名调用因此使用static修饰方法
     *
     * @param connection 数据库连接对象
     * @param statement  sql语句执行对象
     */
    public static void close(Connection connection, PreparedStatement statement) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 释放资源
     * 工具类只需要使用类名调用因此使用static修饰方法
     *
     * @param connection 数据库连接对象
     * @param statement  sql语句执行对象
     */
    public static void close(Connection[] connection, Statement[] statement) {
        for (Connection con : connection) {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        for (Statement sta : statement) {
            if (sta != null) {
                try {
                    sta.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 释放资源
     * 工具类只需要使用类名调用因此使用static修饰方法
     *
     * @param connection 数据库连接对象
     * @param statement  sql语句执行对象
     */
    public static void close(Connection[] connection, PreparedStatement[] statement) {
        for (Connection con : connection) {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        for (Statement sta : statement) {
            if (sta != null) {
                try {
                    sta.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 释放资源
     * 方法重载，可以释放获取结果的资源
     *
     * @param connection 数据库连接对象
     * @param statement  sql语句执行对象
     */
    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        //自身方法
        close(connection, statement);
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}