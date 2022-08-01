package cinema_ticket.dao;

import cinema_ticket.model.ShoppingCart;
import cinema_ticket.model.User;

public interface ShoppingCartDao {
    ShoppingCart add(ShoppingCart shoppingCart);

    ShoppingCart getByUser(User user);

    void update(ShoppingCart shoppingCart);
}
