package utez.edu.mx.fichas_utez_backend.Modules.Registration.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.fichas_utez_backend.Modules.Registration.Controller.DTO.UserRegistrationFormDto;
import utez.edu.mx.fichas_utez_backend.kernel.ResponseApi;
import utez.edu.mx.fichas_utez_backend.Modules.Registration.Model.UserRegistrationForm;
import utez.edu.mx.fichas_utez_backend.Modules.Registration.Service.UserRegistrationFormService;

@Slf4j
@RestController
@RequestMapping("/user-registration-forms")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@Tag(name = "Ficha de Registro", description = "Controlador para manejar la ficha de registro de usuario")
public class UserRegistrationFormController {
    private final UserRegistrationFormService service;
    private static  final ResponseEntity<ResponseApi<?>> ERROR_RESPONSE = new ResponseEntity<>(new ResponseApi<>(HttpStatus.INTERNAL_SERVER_ERROR,500),HttpStatus.INTERNAL_SERVER_ERROR);


    @Operation(summary = "Crear ficha de registro", description = "Crea una nueva ficha de registro de usuario")
    @PostMapping
    public ResponseEntity<ResponseApi<?>> create(@RequestBody UserRegistrationFormDto form) {
        try {
            log.info("ini.UserRegistrationFormController.create -> Creando ficha de registro");
            ResponseApi<?> response = service.create(form);
            log.info("end.UserRegistrationFormController.create -> Ficha creada con id {}", response.getData() );
            return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getCode()));
        }catch (Exception e) {
            log.error("UserRegistrationFormController.create -> Error al crear ficha de registro", e);
            return ERROR_RESPONSE;
        }
    }
}

