package projet.wcs.starter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projet.wcs.starter.dao.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
