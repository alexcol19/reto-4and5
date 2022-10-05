package ciclo3.ciclo3.controllers;

import ciclo3.ciclo3.entities.Costume;
import ciclo3.ciclo3.entities.Reservations;
import ciclo3.ciclo3.services.CostumeService;
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

    @RequestMapping("/all")
    public List<Reservations> getReservaciones(){
        return reservationsService.getReservaciones();
    }

    @GetMapping("/{id}")
    public Optional<Reservations> getReservacionesId(@PathVariable("id") int id){
        return reservationsService.getReservacionId(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservations guardarReservacion(@RequestBody Reservations reservation){
        return reservationsService.guardarReservacion(reservation);
    }
}
