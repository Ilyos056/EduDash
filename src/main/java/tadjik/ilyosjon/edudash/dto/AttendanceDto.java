package tadjik.ilyosjon.edudash.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tadjik.ilyosjon.edudash.model.Exams;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceDto {

    private String studentList;
    private String attendance_statistics;
    private Exams examResult;
}
