package utez.edu.mx.fichas_utez_backend.Modules.HighSchoolType.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "high_school_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HighSchoolType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = true, unique = true)
    private String abrevation;

    public HighSchoolType(String name, String abrevation) {
        this.name = name;
        this.abrevation = abrevation;
    }
}
