package labs.week_03.streams;

import labs.week_03.entity.Order;
import labs.week_03.entity.OrderLine;
import labs.week_03.entity.User;
import labs.week_03.enums.OrderStatus;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class SearchExercise {
    /**
     * extract all active orders
     * @param user
     * @return List<Order>
     */
    public List<Order> getActiveOrders(User user) {
        List<Order> l = user.getOrders().stream()
                .filter(o -> o.getStatus() == OrderStatus.Active)
                .collect(Collectors.toList());
        return l;
    }

    public List<Order> getActiveOrdersByIteration(User user) {
        List<Order> l = new ArrayList<>();
        for(Order o: user.getOrders())
        {
            if(o.getStatus() == OrderStatus.Active)
            {
                l.add(o);
            }
        }
        return l;
    }

    /**
     * Return order by a specific id
     * @param orders
     * @param orderId
     * @return Order
     */
    public Order getOrderById(List<Order> orders, long orderId) {
        Order o = (Order)orders.stream().filter(order -> order.getId() == orderId).findAny().orElse(null);
        return o;
    }

    public Order getOrderByIdIteration(List<Order> orders, long orderId) {
        for(Order o: orders)
        {
            if(o.getId() == orderId)
            {
                return o;
            }
        }
        return null;
    }

    /**
     * Return orders that have specific description for item
     * @param user
     * @param description
     * @return List<Order>
     */
    public List<Order> getOrdersThatHaveItemDescription(User user, String description) {
        List<Order> l = user.getOrders().stream()
                .filter(o ->
                        o.getOrderLines().stream()
                                .anyMatch(i -> i.getItem().getDescription().equals(description)))
                .collect(Collectors.toList());
        return l;
    }

    /**
     * @return true if customer has at least one order with status ACTIVE
     */
    public boolean hasActiveOrders(User user) {
        long count = user.getOrders().stream()
                .filter(o -> o.getStatus() == OrderStatus.Active)
                .count();
        if(count>=1)
        {
            return true;
        }
        return false;
    }

    /**
     * Return true if inside the Order we don't have OrderLine with special offer
     */
    public boolean canBeReturned(Order order) {
        long count = order.getOrderLines().stream()
                .filter(i -> i.getSpecialOffer() == true). count();

        if(count==0)
        {
            return true;
        }
        return false;
    }

    /**
     * Return the order with maximum total price
     * @param user
     * @return
     */
    public Optional<Order> getMaxPriceOrder(User user) {
        Optional<Order> l = user.getOrders().stream()
                .sorted(Comparator.comparing(Order::getTotalPrice).reversed()).findFirst();
        return l;
    }
}
