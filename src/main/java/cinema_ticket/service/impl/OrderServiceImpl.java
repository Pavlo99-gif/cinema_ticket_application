package cinema_ticket.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import cinema_ticket.dao.OrderDao;
import cinema_ticket.lib.Inject;
import cinema_ticket.lib.Service;
import cinema_ticket.model.Order;
import cinema_ticket.model.ShoppingCart;
import cinema_ticket.model.User;
import cinema_ticket.service.OrderService;
import cinema_ticket.service.ShoppingCartService;

@Service
public class OrderServiceImpl implements OrderService {
    @Inject
    private OrderDao orderDao;
    @Inject
    private ShoppingCartService shoppingCartService;
    
    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        Order order = new Order();
        order.setUser(shoppingCart.getUser());
        order.setTickets(new ArrayList<>(shoppingCart.getTickets()));
        order.setOrderDate(LocalDateTime.now());
        shoppingCartService.clearShoppingCart(shoppingCart);
        return orderDao.add(order);
    }
    
    @Override
    public List<Order> getOrdersHistory(User user) {
        return orderDao.getByUser(user);
    }
}
