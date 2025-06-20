package utez.edu.mx.fichas_utez_backend.Modules.MediaChannel.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "media_channels")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MediaChannel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    public MediaChannel(String name) {
        this.name = name;
    }
}

