package ciclo3.ciclo3.Repository;


import ciclo3.ciclo3.Repository.CrudRepository.ReservationsCrudRepository;
import ciclo3.ciclo3.entities.Client;
import ciclo3.ciclo3.entities.DTOs.CountClient;
import ciclo3.ciclo3.entities.Reservations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
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


    //RETO 5
    public List<CountClient> getTopClientes(){
        List<CountClient> respuesta = new ArrayList<>();
        List<Object[]> reporte = reservationsCrudRepository.countTotalReservationsByClient();
        for(int i = 0; i<reporte.size(); i++){
            respuesta.add(new CountClient((Long) reporte.get(i)[1], (Client) reporte.get(i)[0]));
        }
        return respuesta;
    }

    public List<Reservations> getReservationsBetweenDates(Date a,Date b){
        return reservationsCrudRepository.findAllByStartDateAfterAndDevolutionDateBefore(a, b);
    }

    public List<Reservations> getReservationsByStatus(String status){
        return reservationsCrudRepository.findAllByStatus(status);
    }

}












