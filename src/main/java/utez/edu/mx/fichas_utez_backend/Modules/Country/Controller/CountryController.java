package utez.edu.mx.fichas_utez_backend.Modules.Country.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utez.edu.mx.fichas_utez_backend.kernel.ResponseApi;
import utez.edu.mx.fichas_utez_backend.Modules.Country.Model.Country;
import utez.edu.mx.fichas_utez_backend.Modules.Country.Service.CountryService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/countries")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@Tag(name = "Países", description = "Controlador para manejar los países")
public class CountryController {
    private final CountryService service;

    @Operation(summary = "Obtener todos los países", description = "Devuelve una lista de todos los países registrados")
    @GetMapping
    public ResponseApi<List<Country>> getAll() {
        log.info("ini.CountryController.getAll -> Fetching all countries");
        List<Country> countries = service.findAll();
        log.info("end.CountryController.getAll -> Fetched {} countries", countries.size());
        return ResponseApi.success(countries);
    }
}

