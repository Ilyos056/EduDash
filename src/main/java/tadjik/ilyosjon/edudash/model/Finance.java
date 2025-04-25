package tadjik.ilyosjon.edudash.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Finance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String profit;
    @Column (nullable = false)
    private String expenditure;
    @Column (nullable = false)
    private String monthlyBudget;
    @ManyToMany
    private List<Reports> reportId;
    @ManyToMany
    private List<StudentPayment> studentpaymentId;
}
