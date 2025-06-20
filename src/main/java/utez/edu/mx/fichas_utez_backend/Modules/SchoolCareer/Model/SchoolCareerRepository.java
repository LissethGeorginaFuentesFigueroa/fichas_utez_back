package utez.edu.mx.fichas_utez_backend.Modules.SchoolCareer.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolCareerRepository extends JpaRepository<SchoolCareer, Long> {
}

