package utez.edu.mx.fichas_utez_backend.Modules.State.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.fichas_utez_backend.kernel.ResponseApi;
import utez.edu.mx.fichas_utez_backend.Modules.State.Model.State;
import utez.edu.mx.fichas_utez_backend.Modules.State.Service.StateService;

import java.util.List;

@RestController
@RequestMapping("/states")
@RequiredArgsConstructor
@Tag(name = "Estados", description = "Controlador para manejar los estados")
public class StateController {
    private final StateService service;

    @Operation(summary = "Obtener todos los estados", description = "Devuelve una lista de todos los estados registrados")
    @GetMapping
    public ResponseApi<List<State>> getAll() {
        List<State> states = service.findAll();
        return ResponseApi.success(states);
    }

    @Operation(summary = "Obtener los estados por país", description = "Devuelve una lista de estados filtrados por el id del país")
    @GetMapping("/country/{countryId}")
    public ResponseApi<List<State>> getByCountry(@PathVariable Long countryId) {
        List<State> states = service.findByCountryId(countryId);
        return ResponseApi.success(states);
    }
}
