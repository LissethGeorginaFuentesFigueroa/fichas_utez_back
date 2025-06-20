package utez.edu.mx.fichas_utez_backend.Modules.HighSchoolType.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utez.edu.mx.fichas_utez_backend.kernel.ResponseApi;
import utez.edu.mx.fichas_utez_backend.Modules.HighSchoolType.Model.HighSchoolType;
import utez.edu.mx.fichas_utez_backend.Modules.HighSchoolType.Service.HighSchoolTypeService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/high-school-types")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@Tag(name = "Tipos de plantel de media superior", description = "Controlador para manejar los tipos de plantel de media superior")
public class HighSchoolTypeController {
    private final HighSchoolTypeService service;

    @Operation(summary = "Obtener todos los tipos de plantel de media superior", description = "Devuelve una lista de todos los tipos de plantel de media superior registrados")
    @GetMapping
    public ResponseApi<List<HighSchoolType>> getAll() {
        log.info("ini.HighSchoolTypeController.getAll -> Fetching all high school types");
        List<HighSchoolType> types = service.getAllHighSchoolTypes();
        log.info("end.HighSchoolTypeController.getAll -> Fetched {} high school types", types.size());
        return ResponseApi.success(types);
    }
}

