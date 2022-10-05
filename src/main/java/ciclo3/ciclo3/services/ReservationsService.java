package ciclo3.ciclo3.services;

import ciclo3.ciclo3.Repository.CostumeRepository;
import ciclo3.ciclo3.Repository.ReservationRepository;
import ciclo3.ciclo3.entities.Costume;
import ciclo3.ciclo3.entities.Reservations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationsService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservations> getReservations(){
        return reservationRepository.getReservations();
    }
    public Optional<Reservations> getReservationId(int id){
       return reservationRepository.getReservationId(id);
    }
    public Reservations saveReservation(Reservations reservation){
        if(reservation.getIdReservation()==null){
            return reservationRepository.saveReservation(reservation);
        }else{
            Optional<Reservations> paux= reservationRepository.getReservationId(reservation.getIdReservation());
            if(paux.isEmpty()){
                return reservationRepository.saveReservation(reservation);
            }else
                return reservation;
        }
    }
}
