package utez.edu.mx.fichas_utez_backend.Modules.State.Model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StateRepository extends JpaRepository<State, Long> {
    List<State> findByCountry_Id(Long countryId);
}
