package JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author 柳继纪
 * @date 13/5/2022
 * @apiNote
 */
public class JDBCDemo6 {
    public static void main(String[] args) {
        List<Emp> list = new JDBCDemo6().getInfoFromSql();
        ListIterator<Emp>empListIterator = list.listIterator();
        while (empListIterator.hasNext()){
            System.out.println(empListIterator.next());
        }
    }

    public List<Emp> getInfoFromSql() {
        Connection connection = null;
        Statement statement = null;
        List<Emp> set = new ArrayList<Emp>();
        try {
            connection = DriverManager.getConnection("jdbc:mysql:///study", "root", "525658");
            statement = connection.createStatement();
            String sql = "select * from account";
            ResultSet resultSet = statement.executeQuery(sql);
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
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return set;
    }
}
