package projet.wcs.starter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.wcs.starter.entities.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
