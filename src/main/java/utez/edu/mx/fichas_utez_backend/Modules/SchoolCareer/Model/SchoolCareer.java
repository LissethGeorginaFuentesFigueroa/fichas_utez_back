package utez.edu.mx.fichas_utez_backend.Modules.SchoolCareer.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "school_careers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolCareer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    public SchoolCareer(String name) {
        this.name = name;
    }
}

