package utez.edu.mx.fichas_utez_backend.Modules.Municipality.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utez.edu.mx.fichas_utez_backend.Modules.State.Model.State;

@Entity
@Table(name = "municipalities")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Municipality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "state_id")
    private State state;

    public Municipality(String name, State state) {
        this.name = name;
        this.state = state;
    }
}

