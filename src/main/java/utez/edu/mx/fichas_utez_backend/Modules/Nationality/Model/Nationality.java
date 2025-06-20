package utez.edu.mx.fichas_utez_backend.Modules.Nationality.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "nationalities")
@Data
@NoArgsConstructor
public class Nationality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    public Nationality(String name) {
        this.name = name;
    }
}
