package utez.edu.mx.fichas_utez_backend.Modules.HighSchoolType.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HighSchoolTypeRepository extends JpaRepository<HighSchoolType, Long> {
    Optional<HighSchoolType> findByAbrevation(String abrevation);

}

