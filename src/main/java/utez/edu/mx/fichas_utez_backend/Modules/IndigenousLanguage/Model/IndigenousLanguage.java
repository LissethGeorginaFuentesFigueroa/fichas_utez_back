package utez.edu.mx.fichas_utez_backend.Modules.IndigenousLanguage.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "indigenous_languages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndigenousLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    public IndigenousLanguage(String name) {
        this.name = name;
    }
}

