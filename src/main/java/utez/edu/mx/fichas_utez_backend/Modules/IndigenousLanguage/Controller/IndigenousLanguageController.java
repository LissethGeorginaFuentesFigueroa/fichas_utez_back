package utez.edu.mx.fichas_utez_backend.Modules.IndigenousLanguage.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utez.edu.mx.fichas_utez_backend.Modules.IndigenousLanguage.Model.IndigenousLanguage;
import utez.edu.mx.fichas_utez_backend.Modules.IndigenousLanguage.Service.IndigenousLanguageService;
import java.util.List;

@Tag(name = "Lenguas Indígenas", description = "Operaciones relacionadas con las lenguas indígenas")
@RestController
@RequestMapping("/indigenous-languages")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class IndigenousLanguageController {
    private final IndigenousLanguageService indigenousLanguageService;

    @Operation(summary = "Obtener todas las lenguas indígenas", description = "Retorna una lista de todas las lenguas indígenas registradas.")
    @GetMapping
    public ResponseEntity<List<IndigenousLanguage>> getAllIndigenousLanguages() {
        List<IndigenousLanguage> languages = indigenousLanguageService.getAllIndigenousLanguages();
        return ResponseEntity.ok(languages);
    }
}
