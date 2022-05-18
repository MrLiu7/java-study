package DataSource.JDBC.JDBCUtils;

import DataSource.JDBC.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 柳继纪
 * @date 13/5/2022
 * @apiNote
 */
public class JDBCUtilsTest {
    public static void main(String[] args) {
        List<Emp> list = new JDBCUtilsTest().getInfoFromSql();
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    public List<Emp> getInfoFromSql() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Emp> set = new ArrayList<Emp>();
        try {
            connection = JDBCUtils.creat();
            statement = connection.createStatement();
            String sql = "select * from account";
            resultSet = statement.executeQuery(sql);
            Emp emp;
            while (resultSet.next()) {
                emp = new Emp();
                emp.setId(resultSet.getInt("id"));
                emp.setName(resultSet.getString("name"));
                emp.setBalance(resultSet.getDouble("balance"));
                emp.setTime(resultSet.getDate("addTime"));
                set.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, statement, resultSet);
        }
        return set;
    }
}
