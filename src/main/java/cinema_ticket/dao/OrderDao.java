package cinema_ticket.dao;

import java.util.List;
import cinema_ticket.model.Order;
import cinema_ticket.model.User;

public interface OrderDao {
    Order add(Order order);
    
    List<Order> getByUser(User user);
}
