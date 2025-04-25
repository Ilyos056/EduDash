package tadjik.ilyosjon.edudash.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.edudash.model.Finance;

public interface FinanceRepo extends JpaRepository<Finance, Long> {
}
