package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 柳继纪
 * @date 12/5/2022
 * @apiNote
 */
public class JDBCDemo2 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            //连接数据库
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/study", "root", "525658");
            //定义sql语句
            String sql = "insert into account(name,balance,id) values('柳继纪',15000,3)";
            //获取 sql 的 Statement
            statement = connection.createStatement();
            //执行sql语句
            int count = statement.executeUpdate(sql);
            //处理结果
            if (count > 0) {
                System.out.println("插入成功");
            } else {
                System.out.println("插入失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //释放资源
            //避免空指针异常
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
