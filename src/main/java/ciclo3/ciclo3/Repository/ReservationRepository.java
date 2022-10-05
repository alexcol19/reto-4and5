package ciclo3.ciclo3.Repository;


import ciclo3.ciclo3.Repository.CrudRepository.ReservationsCrudRepository;
import ciclo3.ciclo3.entities.Reservations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationsCrudRepository reservationsCrudRepository;

    public List<Reservations> getReservations(){
        return (List<Reservations>) reservationsCrudRepository.findAll();
    }
    public Optional<Reservations> getReservationId(int id){
        return reservationsCrudRepository.findById(id);
    }
    public Reservations saveReservation(Reservations reservation){
        return reservationsCrudRepository.save(reservation);
    }
    public void deleteReservation(Reservations reservation){
        reservationsCrudRepository.delete(reservation);
    }
}
