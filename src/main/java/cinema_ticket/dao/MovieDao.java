package cinema_ticket.dao;

import java.util.List;
import java.util.Optional;
import cinema_ticket.model.Movie;

public interface MovieDao {
    Movie add(Movie movie);

    Optional<Movie> get(Long id);

    List<Movie> getAll();
}
