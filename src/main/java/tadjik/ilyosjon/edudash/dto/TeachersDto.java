package tadjik.ilyosjon.edudash.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeachersDto {

    private String TeacherList;
    private Long subjectId;
    private String result;
}
