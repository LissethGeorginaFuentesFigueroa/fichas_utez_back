package utez.edu.mx.fichas_utez_backend.Modules.IndigenousLanguage.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utez.edu.mx.fichas_utez_backend.Modules.IndigenousLanguage.Model.IndigenousLanguageRepository;
import utez.edu.mx.fichas_utez_backend.Modules.IndigenousLanguage.Model.IndigenousLanguage;

import java.util.List;

@Service
public class IndigenousLanguageService {
    private final IndigenousLanguageRepository indigenousLanguageRepository;

    @Autowired
    public IndigenousLanguageService(IndigenousLanguageRepository indigenousLanguageRepository) {
        this.indigenousLanguageRepository = indigenousLanguageRepository;
    }

    public List<IndigenousLanguage> getAllIndigenousLanguages() {
        return indigenousLanguageRepository.findAll();
    }
}

