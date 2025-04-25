package tadjik.ilyosjon.edudash.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LatestNewsDto {
    private String title;
    private String description;
}
