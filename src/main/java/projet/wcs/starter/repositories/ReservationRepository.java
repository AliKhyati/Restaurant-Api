package projet.wcs.starter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.wcs.starter.dao.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
