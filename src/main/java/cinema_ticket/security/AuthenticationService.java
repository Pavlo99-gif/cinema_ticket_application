package cinema_ticket.security;

import cinema_ticket.exception.AuthenticationException;
import cinema_ticket.exception.RegistrationException;
import cinema_ticket.model.User;

public interface AuthenticationService {
    User login(String email, String password) throws AuthenticationException;

    User register(String email, String password) throws RegistrationException;
}
