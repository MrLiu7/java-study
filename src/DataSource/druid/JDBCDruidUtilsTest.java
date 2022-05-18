package DataSource.druid;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * 使用新的工具类
 *
 * @author 柳继纪
 * @date 14/5/2022
 * @apiNote
 */
public class JDBCDruidUtilsTest {
    public static void main(String[] args) throws Exception {
        /*
        完成添加操作：给数据库添加一条记录
         */
        //使用工具类获取DataSource
        Connection connection = JDBCDruidUtils.createConnection();
        //定义SQL语句
        //注意，不能忽视sql 的一些自动增长的参数，这些值应该给予null
        String addSQL = "insert into user values (null,?,?,?)";
        //获取prepareStatement对象
        PreparedStatement preparedStatement = connection.prepareStatement(addSQL);
        //设置参数
        preparedStatement.setString(1, "王五");
        preparedStatement.setString(2, "147852");
        preparedStatement.setDouble(3, 6000);
        //执行sql语句
        int i = preparedStatement.executeUpdate();
        if (i > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
        //释放资源
        JDBCDruidUtils.closeConnection(preparedStatement, connection);
    }
}
