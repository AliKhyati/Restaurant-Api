package projet.wcs.starter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import projet.wcs.starter.dao.Reservation;
import projet.wcs.starter.dto.ReservationDto;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    @Query("SELECT r from Reservation r WHERE r.date = ?1")
    List<Reservation> findByDate(Date date);
}
