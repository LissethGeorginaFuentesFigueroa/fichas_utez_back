package utez.edu.mx.fichas_utez_backend.Modules.NativeLanguage.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utez.edu.mx.fichas_utez_backend.Modules.NativeLanguage.Model.NativeLanguage;
import utez.edu.mx.fichas_utez_backend.Modules.NativeLanguage.Service.NativeLanguageService;

import java.util.List;

@Tag(name = "Lengua Natal", description = "Operaciones relacionadas con las lenguas natales")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/native-languages")
public class NativeLanguageController {
    private final NativeLanguageService nativeLanguageService;

    @Autowired
    public NativeLanguageController(NativeLanguageService nativeLanguageService) {
        this.nativeLanguageService = nativeLanguageService;
    }

    @Operation(summary = "Obtener todas las lenguas natales", description = "Retorna una lista de todas las lenguas natales registradas.")
    @GetMapping
    public ResponseEntity<List<NativeLanguage>> getAllNativeLanguages() {
        List<NativeLanguage> languages = nativeLanguageService.getAllNativeLanguages();
        return ResponseEntity.ok(languages);
    }
}
