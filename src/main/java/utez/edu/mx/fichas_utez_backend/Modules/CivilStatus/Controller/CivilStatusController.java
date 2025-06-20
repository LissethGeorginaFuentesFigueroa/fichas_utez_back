package utez.edu.mx.fichas_utez_backend.Modules.CivilStatus.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utez.edu.mx.fichas_utez_backend.Modules.CivilStatus.Model.CivilStatus;
import utez.edu.mx.fichas_utez_backend.Modules.CivilStatus.Service.CivilStatusService;

import java.util.List;

@Tag(name = "Estado Civil", description = "Operaciones relacionadas con los estados civiles")
@RestController
@RequestMapping("/civil-status")
@CrossOrigin(origins = "http://localhost:3000")
public class CivilStatusController {
    private final CivilStatusService civilStatusService;

    @Autowired
    public CivilStatusController(CivilStatusService civilStatusService) {
        this.civilStatusService = civilStatusService;
    }

    @Operation(summary = "Obtener todos los estados civiles", description = "Retorna una lista de todos los estados civiles disponibles.")
    @GetMapping
    public ResponseEntity<List<CivilStatus>> getAllCivilStatus() {
        List<CivilStatus> statuses = civilStatusService.getAllCivilStatus();
        return ResponseEntity.ok(statuses);
    }
}
