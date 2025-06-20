package utez.edu.mx.fichas_utez_backend.Modules.NativeLanguage.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "native_languages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NativeLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    public NativeLanguage(String name) {
        this.name = name;
    }
}

