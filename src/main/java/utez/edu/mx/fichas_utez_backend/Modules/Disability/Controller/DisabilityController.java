package utez.edu.mx.fichas_utez_backend.Modules.Disability.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.fichas_utez_backend.kernel.ResponseApi;
import utez.edu.mx.fichas_utez_backend.Modules.Disability.Model.Disability;
import utez.edu.mx.fichas_utez_backend.Modules.Disability.Service.DisabilityService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/disabilities")
@Tag(name = "Discapacidades", description = "Controlador para manejar las discapacidades")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class DisabilityController {

    private final DisabilityService service;

    @Operation(summary = "Obtener todas las discapacidades", description = "Devuelve una lista de todas las discapacidades registradas")
    @GetMapping
    public ResponseApi<List<Disability>> getAll() {
        log.info("ini.DisabilityController.getAll -> Fetching all disabilities");
        List<Disability> disabilities = service.findAll();
        log.info("end.DisabilityController.getAll -> Fetched {} disabilities", disabilities.size());
        return ResponseApi.success(disabilities);
    }


}
