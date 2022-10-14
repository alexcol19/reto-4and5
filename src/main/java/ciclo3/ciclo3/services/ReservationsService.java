package ciclo3.ciclo3.services;

import ciclo3.ciclo3.Repository.CostumeRepository;
import ciclo3.ciclo3.Repository.ReservationRepository;
import ciclo3.ciclo3.entities.Costume;
import ciclo3.ciclo3.entities.DTOs.CountClient;
import ciclo3.ciclo3.entities.DTOs.CountStatus;
import ciclo3.ciclo3.entities.Reservations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public Reservations update(Reservations reservations) {
        if (reservations.getIdReservation() != null) {
            Optional<Reservations> e = reservationRepository.getReservationId(reservations.getIdReservation()); //ojo//
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
                reservationRepository.saveReservation(e.get());
                return e.get();
            }else{
                return reservations;
            }
        }else{
            return reservations;
        }
    }


    public boolean deleteReservation(int id){
        Boolean d = getReservationId(id).map(reservation -> {
            reservationRepository.deleteReservation(reservation);
            return true;
        }).orElse(false);
        return d;
    }

    //RETO 5

    public List<CountClient> getTopClientes(){
        return reservationRepository.getTopClientes();
    }
    
    public List<Reservations> getReservationsBetweenDates(String dateA,String dateB){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();
        try{
            a = parser.parse(dateA);
            b = parser.parse(dateB);
        }catch (ParseException error){
            error.printStackTrace();
        }
        if(a.before(b)){
            return reservationRepository.getReservationsBetweenDates(a, b);
        }else{
            return new ArrayList<>();
        }
    }

    public CountStatus getReservationsSatus(){
        List<Reservations> reservasCompletadas = reservationRepository.getReservationsByStatus("completed");
        List<Reservations> reservasCanceladas = reservationRepository.getReservationsByStatus("cancelled");

        return new CountStatus((long) reservasCompletadas.size(), (long) reservasCanceladas.size());
    }

}
