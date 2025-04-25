package tadjik.ilyosjon.edudash.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.edudash.model.LatestNews;


public interface LatestNewsRepo extends JpaRepository<LatestNews, Long> {
    boolean existsById(Long id);
}
