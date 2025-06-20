package utez.edu.mx.fichas_utez_backend.Modules.HighSchool.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utez.edu.mx.fichas_utez_backend.kernel.ResponseApi;
import utez.edu.mx.fichas_utez_backend.Modules.HighSchool.Model.HighSchool;
import utez.edu.mx.fichas_utez_backend.Modules.HighSchool.Service.HighSchoolService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/high-schools")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@Tag(name = "Preparatorias", description = "Controlador para manejar las preparatorias (planteles de media superior)")
public class HighSchoolController {
    private final HighSchoolService service;

    @Operation(summary = "Obtener todas las preparatorias", description = "Devuelve una lista de todas las preparatorias registradas")
    @GetMapping
    public ResponseApi<List<HighSchool>> getAll() {
        log.info("ini.HighSchoolController.getAll -> Fetching all high schools");
        List<HighSchool> highSchools = service.getAllHighSchools();
        log.info("end.HighSchoolController.getAll -> Fetched {} high schools", highSchools.size());
        return ResponseApi.success(highSchools);
    }
}

