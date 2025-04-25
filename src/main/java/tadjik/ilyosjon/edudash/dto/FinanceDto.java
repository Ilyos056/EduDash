package tadjik.ilyosjon.edudash.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tadjik.ilyosjon.edudash.model.Reports;
import tadjik.ilyosjon.edudash.model.StudentPayment;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinanceDto {

    private String profit;
    private String expenditure;
    private String monthlyBudget;
    private Long reportId;
    private Long studentpaymentId;
}
