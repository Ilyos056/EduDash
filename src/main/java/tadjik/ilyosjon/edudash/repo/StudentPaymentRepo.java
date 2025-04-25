package tadjik.ilyosjon.edudash.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.edudash.model.StudentPayment;

public interface StudentPaymentRepo extends JpaRepository<StudentPayment, Long> {
}
