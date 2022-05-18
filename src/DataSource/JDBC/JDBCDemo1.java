package DataSource.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author 柳继纪
 * @date 12/5/2022
 * @apiNote
 */
public class JDBCDemo1 {
    public static void main(String[] args) throws Exception {
        //1、导入jar包到项目的libs目录下
        //2、注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //3、获取数据库连接对象
        //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/study","root","525658");
        //访问本机的可以省去ip地址端口（前提是端口是默认的）
        Connection connection = DriverManager.getConnection("jdbc:mysql:///study","root","525658");
        //4、定义MySQL语句
        String mysql1 = "update account set balance = 2677 where id  = 1";
        String mysql2 = "update account set balance = 8888 where name = '李四'";
        //5、获取mysql对象的 Statement
        Statement statement = connection.createStatement();
        //6、执行mysql语句
        int count1 = statement.executeUpdate(mysql1);
        int count2 = statement.executeUpdate(mysql2);
        //7、处理结果
        System.out.println(count1);
        System.out.println(count2);
        //8、释放资源
        statement.close();
        connection.close();
    }
}
