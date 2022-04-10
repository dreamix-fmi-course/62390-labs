package labs.week_03.entity;

import labs.week_03.enums.OrderStatus;
import labs.week_03.enums.PaymentMethod;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args)
    {
        OrderLine ol1 = new OrderLine(new Item("Pr1", "descr", new BigDecimal(3.5)), false, 4);
        OrderLine ol2 = new OrderLine(new Item("Pr2", "descr", new BigDecimal(6.5)), false, 4);
        OrderLine ol3 = new OrderLine(new Item("Pr3", "descr", new BigDecimal(32.5)), false, 4);

        List<OrderLine> l = new ArrayList<>();
        l.add(ol1);
        l.add(ol2);
        l.add(ol3);

        Order o = new Order(OrderStatus.Booked, l, LocalDateTime.now(), LocalDate.now(), new BigDecimal(0.0), PaymentMethod.Card, 1);
        System.out.println(o);

        User u1 = new User("U1", new ArrayList<>());
        User u2 = new User("U2", new ArrayList<>());

        System.out.println(u1);
        System.out.println(u2);
    }
}
