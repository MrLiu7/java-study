package DataSource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接池参数的验证
 * @author 柳继纪
 * @date 14/5/2022
 * @apiNote
 */
public class C3P0Demo2 {
    public static void main(String[] args) throws SQLException {
        //获取DataSource
        DataSource dataSource = new ComboPooledDataSource();
        //获取链接
        Connection connection;
        for (int i = 0; i < 11; i++) {
            connection = dataSource.getConnection();
            System.out.println(connection);
            if (i==6){
                //归还资源
                connection.close();
            }
        }
    }
}
