package utez.edu.mx.fichas_utez_backend.Modules.Registration.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utez.edu.mx.fichas_utez_backend.Modules.Registration.Controller.dto.UserRegistrationFormRequest;
import utez.edu.mx.fichas_utez_backend.Modules.Registration.Service.UserRegistrationFormService;
import utez.edu.mx.fichas_utez_backend.kernel.ResponseApi;


@Slf4j
@RestController
@RequestMapping("/user-registration-forms")
@RequiredArgsConstructor
@Tag(name = "Ficha de Registro", description = "Controlador para manejar la ficha de registro de usuario")
public class UserRegistrationFormController {

    private final UserRegistrationFormService service;

    @Operation(summary = "Crear ficha de registro", description = "Crea una nueva ficha de registro de usuario")
    @PostMapping
    public ResponseEntity<ResponseApi<?>> create(@Valid @RequestBody UserRegistrationFormRequest form) {
        log.info("ini.UserRegistrationFormController.create -> Creando ficha de registro");
        Boolean created= service.create(form);
        log.info("end.UserRegistrationFormController.create -> Ficha creada con id {}", created);
        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseApi.created(created));
    }
}
