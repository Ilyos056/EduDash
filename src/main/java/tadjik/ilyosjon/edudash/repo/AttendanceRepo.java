package tadjik.ilyosjon.edudash.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.edudash.model.Attendance;

public interface AttendanceRepo extends JpaRepository<Attendance, Long> {
    boolean existsById(Long id);
}
