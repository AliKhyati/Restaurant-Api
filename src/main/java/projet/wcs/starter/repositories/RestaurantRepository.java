package projet.wcs.starter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projet.wcs.starter.dao.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {


}
