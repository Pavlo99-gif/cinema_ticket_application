package cinema_ticket.service.impl;

import java.util.List;
import cinema_ticket.dao.MovieDao;
import cinema_ticket.lib.Inject;
import cinema_ticket.lib.Service;
import cinema_ticket.model.Movie;
import cinema_ticket.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
    @Inject
    private MovieDao movieDao;

    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }

    @Override
    public Movie get(Long id) {
        return movieDao.get(id).get();
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }
}
