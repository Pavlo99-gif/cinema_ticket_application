package cinema_ticket.service;

import java.util.List;
import cinema_ticket.model.Order;
import cinema_ticket.model.ShoppingCart;
import cinema_ticket.model.User;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);
    
    List<Order> getOrdersHistory(User user);
}
