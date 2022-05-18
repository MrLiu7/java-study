package DataSource.JDBC.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBC操作事务
 *
 * @author 柳继纪
 * @date 13/5/2022
 * @apiNote
 */
public class JDBCUtils3 {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatementAdd = null;
        PreparedStatement preparedStatementSub = null;
        try {
            connection = JDBCUtils.creat();
            String add = "update user set balance = balance + ? where id = ?";
            String sub = "update user set balance = balance - ? where id = ?";
            //开启事务
            connection.setAutoCommit(false);
            preparedStatementAdd = connection.prepareStatement(add);
            preparedStatementSub = connection.prepareStatement(sub);
            preparedStatementAdd.setDouble(1, 500);
            preparedStatementAdd.setInt(2, 1);
            preparedStatementSub.setDouble(1, 500);
            preparedStatementSub.setInt(2, 2);
            preparedStatementAdd.executeUpdate();
            int a = 5 / 0;
            preparedStatementSub.executeUpdate();
            //提交事务
            connection.commit();
        } catch (Exception e) {
            //回滚事务
            if (connection!=null){
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(new Connection[]{connection, null}, new PreparedStatement[]{preparedStatementAdd, preparedStatementSub});
        }
    }
}
