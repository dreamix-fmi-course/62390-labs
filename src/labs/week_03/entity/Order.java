package labs.week_03.entity;

import labs.week_03.enums.OrderStatus;
import labs.week_03.enums.PaymentMethod;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Order {
    private static Integer idCounter = 0;
    private Integer id;
    private OrderStatus status;
    private List<OrderLine> orderLines;
    private LocalDateTime creationDate;
    private LocalDate deliveryDueDate;
    private BigDecimal totalPrice;
    private PaymentMethod paymentMethod;
    private Integer userId;

    public Order()
    {
        this.id = idCounter;
        idCounter++;
        this.status = OrderStatus.Entered;
        this.orderLines = new ArrayList<>();
        this.creationDate = null;
        this.deliveryDueDate = null;
        this.totalPrice = new BigDecimal(0.0);
        this.paymentMethod = PaymentMethod.Cash;
        this.userId = -1;
    }

    public Order(OrderStatus status, List<OrderLine> orderLines, LocalDateTime creationDate, LocalDate deliveryDueDate, BigDecimal totalPrice, PaymentMethod paymentMethod, Integer userId) {
        this.id = idCounter;
        idCounter++;
        this.status = status;
        this.orderLines = orderLines;
        this.creationDate = creationDate;
        this.deliveryDueDate = deliveryDueDate;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getDeliveryDueDate() {
        return deliveryDueDate;
    }

    public void setDeliveryDueDate(LocalDate deliveryDueDate) {
        this.deliveryDueDate = deliveryDueDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getUser() {
        return this.userId;
    }

    public void setUser(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        str.append("Id: " + this.id + "\n");
        str.append("User id: " + this.userId + "\n");
        str.append("Status: " + this.status.toString() + "\n");
        for(OrderLine ol: this.orderLines)
        {
            str.append(ol.getItem().getProductName() + ": " + ol.getItem().getPrice() + " * " + ol.getCount() + " = " + ol.getItem().getPrice().multiply(BigDecimal.valueOf(ol.getCount())) + "\n");
        }
        str.append("Ordered at: " + this.creationDate + "\n");
        str.append("Delivery date: " + this.deliveryDueDate + "\n");
        str.append("Total price: " + this.totalPrice + "\n");
        str.append("Payment method: " + this.paymentMethod.toString() + "\n");

        return str.toString();
    }
}
