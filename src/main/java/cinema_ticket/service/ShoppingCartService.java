package cinema_ticket.service;

import cinema_ticket.model.MovieSession;
import cinema_ticket.model.ShoppingCart;
import cinema_ticket.model.User;

public interface ShoppingCartService {
    void addSession(MovieSession movieSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clearShoppingCart(ShoppingCart cart);
}
