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

    public List<Reservations> getReservaciones(){
        return reservationRepository.getReservaciones();
    }
    public Optional<Reservations> getReservacionId(int id){
       return reservationRepository.getReservacionId(id);
    }
    public Reservations guardarReservacion(Reservations reservation){
        if(reservation.getIdReservation()==null){
            return reservationRepository.guardarReservacion(reservation);
        }else{
            Optional<Reservations> paux= reservationRepository.getReservacionId(reservation.getIdReservation());
            if(paux.isEmpty()){
                return reservationRepository.guardarReservacion(reservation);
            }else
                return reservation;
        }
    }
}
