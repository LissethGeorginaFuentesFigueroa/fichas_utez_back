package utez.edu.mx.fichas_utez_backend.Modules.Registration.Controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Antecedente escolar de preparatoria del usuario")
public record HighSchoolBackgroundRequest(

        @Schema(description = "ID del tipo de preparatoria", example = "1")
        @NotNull Long highSchoolTypeId,

        @Schema(description = "Nombre de la preparatoria", example = "Preparatoria Oficial 123")
        @NotBlank String highSchoolName,

        @Schema(description = "Clave CCT de la preparatoria", example = "123456789012")
        @NotBlank String cct,

        @Schema(description = "ID del estado de la preparatoria", example = "17")
        @NotNull Long stateId,

        @Schema(description = "ID del municipio de la preparatoria", example = "23")
        @NotNull Long municipalityId,

        @Schema(description = "Promedio obtenido", example = "9.2")
        @NotNull
        @DecimalMin(value = "6.0", message = "El promedio debe ser al menos 6.0")
        @DecimalMax(value = "10.0", message = "El promedio no puede ser mayor a 10.0")
        Double average,

        @Schema(description = "¿Cuenta con beca?", example = "true")
        @NotNull Boolean hasScholarship,

        @Schema(description = "Nombre de la beca (obligatorio si hasScholarship es true)", example = "Beca Benito Juárez")
        String scholarshipName

) {}
