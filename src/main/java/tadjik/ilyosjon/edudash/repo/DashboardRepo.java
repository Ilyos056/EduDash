package tadjik.ilyosjon.edudash.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.edudash.model.Dashboard;

import java.util.List;

public interface DashboardRepo extends JpaRepository<Dashboard, Long> {
    boolean existsById(Long id);
}
