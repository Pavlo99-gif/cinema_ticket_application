package cinema_ticket.service;

import java.util.List;
import cinema_ticket.model.CinemaHall;

public interface CinemaHallService {
    CinemaHall add(CinemaHall cinemaHall);

    CinemaHall get(Long id);
    
    List<CinemaHall> getAll();
}
