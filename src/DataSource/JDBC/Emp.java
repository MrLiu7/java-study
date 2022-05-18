package DataSource.JDBC;

import java.util.Date;

/**
 * @author 柳继纪
 * @date 13/5/2022
 * @apiNote
 */
public class Emp {
    private int id;
    private double balance;
    private String name;
    //sql中的date继承util中的date
    private Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", balance=" + balance +
                ", name='" + name + '\'' +
                ", time=" + time +
                '}';
    }
}
