package utez.edu.mx.fichas_utez_backend.Modules.Disability.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "disabilities")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Disability {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    public Disability(String name) {
        this.name = name;
    }
}
