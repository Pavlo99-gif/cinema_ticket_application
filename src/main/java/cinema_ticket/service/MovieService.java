package cinema_ticket.service;

import java.util.List;
import cinema_ticket.model.Movie;

public interface MovieService {
    Movie add(Movie movie);

    Movie get(Long id);

    List<Movie> getAll();
}
