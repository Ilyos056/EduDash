package tadjik.ilyosjon.edudash.model;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dashboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private Integer studentNumber;
    @Column(nullable = false)
    private String teacherResult;
    @OneToMany
    private List<LatestNews> latestNewsId;
}
