package DataSource.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 柳继纪
 * @date 12/5/2022
 * @apiNote
 */
public class JDBCDemo3 {
    public static void main(String[] args) {
        //定义数据库连接对象
        Connection connection = null;
        //定义sql执行对象
        Statement statement = null;
        try {
            //连接数据库
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/study", "root", "525658");
            //创建sql执行对象
            statement = connection.createStatement();
            //定义sql语句
            String sql = "update account set balance = 5000 where name='李四' and id = 2";
            //执行sql语句
            int count = statement.executeUpdate(sql);
            //处理结果
            if (count > 0) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
