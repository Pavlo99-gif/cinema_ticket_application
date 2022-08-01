package cinema_ticket.service.impl;

import java.time.LocalDate;
import java.util.List;
import cinema_ticket.dao.MovieSessionDao;
import cinema_ticket.lib.Inject;
import cinema_ticket.lib.Service;
import cinema_ticket.model.MovieSession;
import cinema_ticket.service.MovieSessionService;

@Service
public class MovieSessionServiceImpl implements MovieSessionService {
    @Inject
    private MovieSessionDao sessionDao;

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        return sessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public MovieSession get(Long id) {
        return sessionDao.get(id).get();
    }

    @Override
    public MovieSession add(MovieSession session) {
        return sessionDao.add(session);
    }
}
