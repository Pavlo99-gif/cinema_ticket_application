package cinema_ticket.dao;

import java.util.Optional;
import cinema_ticket.model.User;

public interface UserDao {
    User add(User user);

    Optional<User> findByEmail(String email);
}
