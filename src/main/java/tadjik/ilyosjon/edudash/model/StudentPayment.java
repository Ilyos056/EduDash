package tadjik.ilyosjon.edudash.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import tadjik.ilyosjon.edudash.model.Entity.Status;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StudentPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String amount;
    @CreatedDate
    private LocalDate paymentDate=LocalDate.now();
    @Enumerated(EnumType.STRING)
    private Status paymentStatus;
    @Column(nullable = false)
    private String paymentMethod;
}
