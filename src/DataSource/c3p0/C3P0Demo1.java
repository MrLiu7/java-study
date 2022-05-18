package DataSource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * C3P0的基本创建使用
 * @author 柳继纪
 * @date 14/5/2022
 * @apiNote
 */
public class C3P0Demo1 {
    public static void main(String[] args) throws SQLException {
        //创建数据库连接对象 获取datasource，不传参数那么获取默认配置的数据库
        DataSource dataSource = new ComboPooledDataSource();
        //使用带参的获取DataSource，指定数据库,数据库不存在则报错
        DataSource dataSource1 = new ComboPooledDataSource("student");
        //获取链接对象
        //抛出异常
        Connection connection = dataSource.getConnection();

        //打印检验 出现日志代表成功
        System.out.println(connection);
    }
}
