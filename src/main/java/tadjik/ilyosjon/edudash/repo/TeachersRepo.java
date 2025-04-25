package tadjik.ilyosjon.edudash.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.edudash.model.Teachers;

public interface TeachersRepo extends JpaRepository<Teachers, Long> {
}
