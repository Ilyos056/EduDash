package tadjik.ilyosjon.edudash.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.edudash.model.Reports;

public interface ReportsRepo extends JpaRepository<Reports, Long> {
}
