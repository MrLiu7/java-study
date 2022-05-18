package DataSource.JDBC.JDBCUtils;

import javax.swing.*;
import java.sql.*;

/**
 * 用户输入用户名和密码，匹配数据库是否存在数据，判断密码对错决定给是否允许登录
 *
 * @author 柳继纪
 * @date 13/5/2022
 * @apiNote
 */
public class JDBCUtilsDemo2 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;
        String name = null, password = null;
        boolean isLogin = false;
        while (name == null) {
            name = JOptionPane.showInputDialog(null, "请输入姓名", "用户名输入框", JOptionPane.NO_OPTION);
        }
        while (password == null) {
            password = JOptionPane.showInputDialog(null, "请输入密码", "用户名输入框", JOptionPane.NO_OPTION);
        }
        try {
            connection = JDBCUtils.creat();
            //定义SQL语句
            String sql = "select * from user where name = ? and password = ?";
            //获取prepareStatement对象
            statement = connection.prepareStatement(sql);
            //给sql语句设置参数
            statement.setString(1,name);
            statement.setString(2,password);
            //执行sql语句不需要传入参数
            set = statement.executeQuery();
            String tName, tPassword;
            if (set.next()){
                tName = set.getString("name");
                tPassword = set.getString("password");
                System.out.println(tName);
                if (tName.equals(name) && tPassword.equals(password)) {
                    isLogin = true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, statement, set);
        }
        if (isLogin) {
            JOptionPane.showMessageDialog(null, ("恭喜  ，欢迎回来！"), "登陆结果", JOptionPane.NO_OPTION);
        } else {
            JOptionPane.showMessageDialog(null, "数据库没有您的相关信息", "登陆结果", JOptionPane.ERROR_MESSAGE);
        }
    }
}
