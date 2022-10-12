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

    /*public Reservations update(Reservations reservations) {
        if (reservations.getIdReservation() != null) {
            Optional<Reservations> e = ReservationRepository.getReservations(reservations.getIdReservation()); //ojo//
            if (!e.isEmpty()) {
                if (reservations.getStartDate() != null) {
                    e.get().setStartDate(reservations.getStartDate());
                }
                if (reservations.getDevolutionDate() != null) {
                    e.get().setDevolutionDate(reservations.getDevolutionDate());
                }
                if (reservations.getStatus() != null) {
                    e.get().setStatus(reservations.getStatus());
                }
                reservationRepository.save(e.get()); //ojo//
                return e.get();
            }else{
                return reservations;
            }
        }else{
            return reservations;
        }
    }*/


    /*public boolean deleteReservation(int id){
        Boolean d = getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return d;
    }*/
}
