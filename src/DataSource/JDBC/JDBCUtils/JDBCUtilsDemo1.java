package DataSource.JDBC.JDBCUtils;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 用户输入用户名和密码，匹配数据库是否存在数据，判断密码对错决定给是否允许登录
 *
 * @author 柳继纪
 * @date 13/5/2022
 * @apiNote
 */
public class JDBCUtilsDemo1 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
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
            statement = connection.createStatement();
            String sql = "select * from user";
            set= statement.executeQuery(sql);
            String tName, tPassword;
            while (set.next()) {
                tName = set.getString("name");
                tPassword = set.getString("password");
                if (tName.equals(name) && tPassword.equals(password)) {
                    isLogin= true;
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection,statement,set);
        }
        if (isLogin) {
            JOptionPane.showMessageDialog(null, ("恭喜  ，欢迎回来！"), "登陆结果", JOptionPane.NO_OPTION);
        }else {
            JOptionPane.showMessageDialog(null, "数据库没有您的相关信息", "登陆结果", JOptionPane.ERROR_MESSAGE);
        }
    }
}
