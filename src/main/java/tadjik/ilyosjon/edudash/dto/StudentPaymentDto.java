package tadjik.ilyosjon.edudash.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tadjik.ilyosjon.edudash.model.Entity.Status;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentPaymentDto {
    private String amount;
    private Status paymentStatus;
    private String paymentMethod;
}
