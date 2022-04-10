package labs.week_03.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static Integer idCounter = 0;
    private Integer userId;
    private String userName;
    private List<Order> orders;

    public User()
    {
        this.userId = idCounter;
        idCounter++;
        this.userName = "N/A";
        this.orders = new ArrayList<>();
    }

    public User(String userName, List<Order> orders) {
        this.userId = idCounter;
        idCounter++;
        this.userName = userName;
        this.orders = orders;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString()
    {
        return String.valueOf(this.userId) + " - " + this.userName;
    }
}
