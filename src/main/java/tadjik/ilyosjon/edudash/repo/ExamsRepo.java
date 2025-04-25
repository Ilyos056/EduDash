package tadjik.ilyosjon.edudash.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.edudash.model.Exams;

public interface ExamsRepo extends JpaRepository<Exams, Long> {
    boolean existsById(Long id);
}
