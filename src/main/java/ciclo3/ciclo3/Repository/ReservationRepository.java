package ciclo3.ciclo3.Repository;


import ciclo3.ciclo3.Repository.CrudRepositorio.ReservationsCrudRepository;
import ciclo3.ciclo3.entities.Reservations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationsCrudRepository reservationsCrudRepository;

    public List<Reservations> getReservaciones(){
        return (List<Reservations>) reservationsCrudRepository.findAll();
    }
    public Optional<Reservations> getReservacionId(int id){
        return reservationsCrudRepository.findById(id);
    }
    public Reservations guardarReservacion(Reservations reservation){
        return reservationsCrudRepository.save(reservation);
    }
    public void borrarReservacion(Reservations reservation){
        reservationsCrudRepository.delete(reservation);
    }
}
