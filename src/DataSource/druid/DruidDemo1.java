package DataSource.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * Druid基本演示
 * @author 柳继纪
 * @date 14/5/2022
 * @apiNote
 */
public class DruidDemo1 {
    public static void main(String[] args) throws Exception {
        //导包
        //定义配置文件 文件名任意，文件位置任意
        //手动加载配置文件
        //一步获取到路径
        Properties pro = new Properties();
        InputStream resourceAsStream = DruidDemo1.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(resourceAsStream);
        //获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);
        //获取连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
