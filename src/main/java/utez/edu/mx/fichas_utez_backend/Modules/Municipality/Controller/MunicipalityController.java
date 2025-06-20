package utez.edu.mx.fichas_utez_backend.Modules.Municipality.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.fichas_utez_backend.kernel.ResponseApi;
import utez.edu.mx.fichas_utez_backend.Modules.Municipality.Model.Municipality;
import utez.edu.mx.fichas_utez_backend.Modules.Municipality.Service.MunicipalityService;

import java.util.List;

@RestController
@RequestMapping("/municipalities")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@Tag(name = "Municipios", description = "Controlador para manejar los municipios")
public class MunicipalityController {
    private final MunicipalityService service;

    @Operation(summary = "Obtener todos los municipios", description = "Devuelve una lista de todos los municipios registrados")
    @GetMapping
    public ResponseApi<List<Municipality>> getAll() {
        return ResponseApi.success(service.findAll());
    }

    @Operation(summary = "Obtener municipios por estado", description = "Devuelve una lista de municipios filtrados por el id del estado")
    @GetMapping("/state/{stateId}")
    public ResponseApi<List<Municipality>> getByState(@PathVariable Long stateId) {
        return ResponseApi.success(service.findByStateId(stateId));
    }
}

