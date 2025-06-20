package utez.edu.mx.fichas_utez_backend.Modules.NativeLanguage.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utez.edu.mx.fichas_utez_backend.Modules.NativeLanguage.Model.NativeLanguageRepository;
import utez.edu.mx.fichas_utez_backend.Modules.NativeLanguage.Model.NativeLanguage;

import java.util.List;

@Service
public class NativeLanguageService {
    private final NativeLanguageRepository nativeLanguageRepository;

    @Autowired
    public NativeLanguageService(NativeLanguageRepository nativeLanguageRepository) {
        this.nativeLanguageRepository = nativeLanguageRepository;
    }

    public List<NativeLanguage> getAllNativeLanguages() {
        return nativeLanguageRepository.findAll();
    }
}

