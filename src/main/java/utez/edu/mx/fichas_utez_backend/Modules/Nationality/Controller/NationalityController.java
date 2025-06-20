package utez.edu.mx.fichas_utez_backend.Modules.Nationality.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utez.edu.mx.fichas_utez_backend.kernel.ResponseApi;
import utez.edu.mx.fichas_utez_backend.Modules.Nationality.Model.Nationality;
import utez.edu.mx.fichas_utez_backend.Modules.Nationality.Service.NationalityService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/nationalities")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@Tag(name = "Nacionalidades", description = "Controlador para manejar las nacionalidades")
public class NationalityController {

    private final NationalityService service;

    @Operation(summary = "Obtener todas las nacionalidades", description = "Devuelve una lista de todas las nacionalidades registradas")
    @GetMapping
    public ResponseApi<List<Nationality>> getAll() {
        log.info("ini.NationalityController.getAll -> Fetching all nationalities");
        List<Nationality> nationalities = service.findAll();
        log.info("end.NationalityController.getAll -> Fetched {} nationalities", nationalities.size());
        return ResponseApi.success(nationalities);
    }
}
