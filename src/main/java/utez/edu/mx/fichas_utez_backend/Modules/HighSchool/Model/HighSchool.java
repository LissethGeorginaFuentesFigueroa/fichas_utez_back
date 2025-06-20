package utez.edu.mx.fichas_utez_backend.Modules.HighSchool.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utez.edu.mx.fichas_utez_backend.Modules.HighSchoolType.Model.HighSchoolType;

@Entity
@Table(name = "high_schools")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HighSchool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "type_id")
    private HighSchoolType type;

    public HighSchool(String name, HighSchoolType type) {
        this.name = name;
        this.type = type;
    }

}

