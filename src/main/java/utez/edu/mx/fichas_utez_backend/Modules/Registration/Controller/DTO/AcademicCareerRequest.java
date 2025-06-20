package utez.edu.mx.fichas_utez_backend.Modules.Registration.Controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Datos de la carrera académica de interés del usuario")
public record AcademicCareerRequest(
        @Schema(description = "ID de la carrera de interés", example = "1")
        @NotNull Long careerId,

        @Schema(description = "ID del medio por el que se enteró", example = "2")
        @NotNull Long sourceId,

        @Schema(description = "¿La escuela es primera opción?", example = "true")
        @NotNull Boolean isFirstOption
) {}

