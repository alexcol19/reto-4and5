package ciclo3.ciclo3.controllers;

//import ciclo3.ciclo3.entities.Costume;
import ciclo3.ciclo3.entities.Category;
import ciclo3.ciclo3.entities.Reservations;
//import ciclo3.ciclo3.services.CostumeService;
import ciclo3.ciclo3.services.ReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationController {

    @Autowired
    private ReservationsService reservationsService;

    @GetMapping("/all")
    public List<Reservations> getReservations(){
        return reservationsService.getReservations();
    }

    @GetMapping("/{id}")
    public Optional<Reservations> getReservationsId(@PathVariable("id") int id){
        return reservationsService.getReservationId(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservations saveReservation(@RequestBody Reservations reservation){
        return reservationsService.saveReservation(reservation);
    }

    /*@PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservations update(@RequestBody Reservations reservations){
        return reservationsService.update(reservations);
    }*/

    /*@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return reservationService.deleteReservation(id);
    }*/
}
