package labs.week_03.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int userId;
    private String userName;
    private List<Order> orders;

    public User()
    {
        this.userId = 0;
        this.userName = "N/A";
        this.orders = new ArrayList<>();
    }

    public User(int userId, String userName, List<Order> orders) {
        this.userId = userId;
        this.userName = userName;
        this.orders = orders;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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
}
