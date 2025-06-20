package utez.edu.mx.fichas_utez_backend.Modules.CivilStatus.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CivilStatusRepository extends JpaRepository<CivilStatus, Long> {
}

