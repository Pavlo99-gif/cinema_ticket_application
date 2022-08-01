package cinema_ticket.service.impl;

import java.util.Optional;
import cinema_ticket.dao.UserDao;
import cinema_ticket.lib.Inject;
import cinema_ticket.lib.Service;
import cinema_ticket.model.User;
import cinema_ticket.service.UserService;
import cinema_ticket.util.HashUtil;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private UserDao userDao;

    @Override
    public User add(User user) {
        user.setSalt(HashUtil.getSalt());
        user.setPassword(HashUtil.hashPassword(user.getPassword(), user.getSalt()));
        return userDao.add(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
