package cinema_ticket.service;

import java.util.Optional;
import cinema_ticket.model.User;

public interface UserService {
    User add(User user);

    Optional<User> findByEmail(String email);
}
