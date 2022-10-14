package ciclo3.ciclo3.Repository.CrudRepository;

import ciclo3.ciclo3.entities.Reservations;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationsCrudRepository extends CrudRepository<Reservations,Integer> {
    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c GROUP BY c.client ORDER BY COUNT(c.client) DESC")
    public List<Object[]> countTotlaReservationsByClient();

    public List<Reservations> findAllByStartDateAndDevolutionDateBefore(Date date1, Date date2);

    public List<Reservations> findAllByStatus(String status);
}
