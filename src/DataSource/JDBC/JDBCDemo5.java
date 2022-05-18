package DataSource.JDBC;

import java.sql.*;

/**
 * @author 柳继纪
 * @date 13/5/2022
 * @apiNote
 */
public class JDBCDemo5 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet set = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/study", "root", "525658");
            statement = connection.createStatement();
            String sql = "select * from account";
            //获取结果的方法
            set = statement.executeQuery(sql);
            //游标下一一行，默认指向第一行
            //set.next();
            while (set.next()){
                //处理结果
                //传递字符串的方法获取整数值 工资
                int balance = set.getInt("balance");
                //获取编号
                int id = set.getInt(3);
                //获取姓名
                String name = set.getString("name");
                System.out.println(id + " " + name + " " + balance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
