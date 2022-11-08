package projet.wcs.starter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.wcs.starter.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
