package projet.wcs.starter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.wcs.starter.entities.Command;
@Repository
public interface CommandRepository extends JpaRepository<Command, Integer> {
}
