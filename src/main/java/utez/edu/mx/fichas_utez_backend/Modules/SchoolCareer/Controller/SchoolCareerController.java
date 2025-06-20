package utez.edu.mx.fichas_utez_backend.Modules.SchoolCareer.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utez.edu.mx.fichas_utez_backend.kernel.ResponseApi;
import utez.edu.mx.fichas_utez_backend.Modules.SchoolCareer.Model.SchoolCareer;
import utez.edu.mx.fichas_utez_backend.Modules.SchoolCareer.Service.SchoolCareerService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/school-careers")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@Tag(name = "Carreras escolares", description = "Controlador para manejar las carreras escolares")
public class SchoolCareerController {
    private final SchoolCareerService service;

    @Operation(summary = "Obtener todas las carreras escolares", description = "Devuelve una lista de todas las carreras escolares registradas")
    @GetMapping
    public ResponseApi<List<SchoolCareer>> getAll() {
        log.info("ini.SchoolCareerController.getAll -> Fetching all school careers");
        List<SchoolCareer> careers = service.getAllSchoolCareers();
        log.info("end.SchoolCareerController.getAll -> Fetched {} school careers", careers.size());
        return ResponseApi.success(careers);
    }
}

