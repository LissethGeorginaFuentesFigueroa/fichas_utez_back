package utez.edu.mx.fichas_utez_backend.Modules.HighSchool.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HighSchoolRepository extends JpaRepository<HighSchool, Long> {
}

