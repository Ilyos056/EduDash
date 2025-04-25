package tadjik.ilyosjon.edudash.dto;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tadjik.ilyosjon.edudash.model.LatestNews;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardDto {
    private Integer studentNumber;
    private String teacherResult;
    private Long latestNewsId;

}
