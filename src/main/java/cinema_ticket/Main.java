package cinema_ticket;

import java.time.LocalDate;
import java.time.LocalDateTime;
import cinema_ticket.exception.RegistrationException;
import cinema_ticket.lib.Injector;
import cinema_ticket.model.CinemaHall;
import cinema_ticket.model.Movie;
import cinema_ticket.model.MovieSession;
import cinema_ticket.model.ShoppingCart;
import cinema_ticket.model.User;
import cinema_ticket.security.AuthenticationService;
import cinema_ticket.service.CinemaHallService;
import cinema_ticket.service.MovieService;
import cinema_ticket.service.MovieSessionService;
import cinema_ticket.service.OrderService;
import cinema_ticket.service.ShoppingCartService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.academy");
    
    public static void main(String[] args) throws RegistrationException {
        MovieService movieService =
                (MovieService) injector.getInstance(MovieService.class);
        Movie fastAndFurious = new Movie("Fast and Furious");
        fastAndFurious.setDescription("An action film about street racing, heists, and spies.");
        movieService.add(fastAndFurious);
        System.out.println(movieService.get(fastAndFurious.getId()));
        movieService.getAll().forEach(System.out::println);

        CinemaHall firstCinemaHall = new CinemaHall();
        firstCinemaHall.setCapacity(100);
        firstCinemaHall.setDescription("first hall with capacity 100");

        CinemaHall secondCinemaHall = new CinemaHall();
        secondCinemaHall.setCapacity(200);
        secondCinemaHall.setDescription("second hall with capacity 200");
        
        CinemaHallService cinemaHallService =
                (CinemaHallService) injector.getInstance(CinemaHallService.class);
        cinemaHallService.add(firstCinemaHall);
        cinemaHallService.add(secondCinemaHall);

        System.out.println(cinemaHallService.getAll());
        System.out.println(cinemaHallService.get(firstCinemaHall.getId()));

        MovieSession tomorrowMovieSession = new MovieSession();
        tomorrowMovieSession.setCinemaHall(firstCinemaHall);
        tomorrowMovieSession.setMovie(fastAndFurious);
        tomorrowMovieSession.setShowTime(LocalDateTime.now().plusDays(1L));

        MovieSession yesterdayMovieSession = new MovieSession();
        yesterdayMovieSession.setCinemaHall(firstCinemaHall);
        yesterdayMovieSession.setMovie(fastAndFurious);
        yesterdayMovieSession.setShowTime(LocalDateTime.now().minusDays(1L));
    
        MovieSessionService movieSessionService =
                (MovieSessionService) injector.getInstance(MovieSessionService.class);
        movieSessionService.add(tomorrowMovieSession);
        movieSessionService.add(yesterdayMovieSession);

        System.out.println(movieSessionService.get(yesterdayMovieSession.getId()));
        System.out.println(movieSessionService.findAvailableSessions(
                        fastAndFurious.getId(), LocalDate.now()));
    
        ShoppingCartService shoppingCartService =
                (ShoppingCartService) injector.getInstance(ShoppingCartService.class);
        AuthenticationService authenticationService =
                (AuthenticationService) injector.getInstance(AuthenticationService.class);
        OrderService orderService =
                (OrderService) injector.getInstance(OrderService.class);
        
        User bob = authenticationService.register("bob", "12345");
        
        shoppingCartService.addSession(yesterdayMovieSession, bob);
    
        ShoppingCart bobShoppingCart = shoppingCartService.getByUser(bob);
        
        orderService.completeOrder(bobShoppingCart);
        orderService.getOrdersHistory(bob);
    }
}
