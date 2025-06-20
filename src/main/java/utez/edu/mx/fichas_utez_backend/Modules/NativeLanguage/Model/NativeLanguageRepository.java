package utez.edu.mx.fichas_utez_backend.Modules.NativeLanguage.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NativeLanguageRepository extends JpaRepository<NativeLanguage, Long> {
}

