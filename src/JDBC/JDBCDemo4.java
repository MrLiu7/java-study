package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 柳继纪
 * @date 13/5/2022
 * @apiNote
 */
public class JDBCDemo4 {
    public static void main(String[] args) {
        //定义数据库连接对象
        Connection connection = null;
        //定义mql执行语句的对象
        Statement statement = null;
        try {
            //连接数据库
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/study", "root", "525658");
            //定义sql语句
            String sql = "delete from account where name='柳继纪'";
            //获取mysql 语句执行对象
            statement = connection.createStatement();
            //执行语句
            int count = statement.executeUpdate(sql);
            //处理结果
            if (count>0){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (statement!=null){
                try {
                    statement.close();
                }catch(SQLException e){
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
