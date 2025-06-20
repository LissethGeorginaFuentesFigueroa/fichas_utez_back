package utez.edu.mx.fichas_utez_backend.Modules.Municipality.Model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MunicipalityRepository extends JpaRepository<Municipality, Long> {
    List<Municipality> findByState_Id(Long stateId);
}

