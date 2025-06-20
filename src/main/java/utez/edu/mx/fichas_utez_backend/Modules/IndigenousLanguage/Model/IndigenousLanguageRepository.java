package utez.edu.mx.fichas_utez_backend.Modules.IndigenousLanguage.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndigenousLanguageRepository extends JpaRepository<IndigenousLanguage, Long> {
}

