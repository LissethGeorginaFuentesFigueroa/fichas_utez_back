package utez.edu.mx.fichas_utez_backend.Modules.Registration.Controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import utez.edu.mx.fichas_utez_backend.Modules.Registration.Controller.dto.enums.Gender;

import java.time.LocalDate;

@Schema(name = "PersonalDataRequest", description = "Datos personales del solicitante para el registro de ficha")
public record PersonalDataRequest(
        @Schema(description = "Nombre(s) del solicitante", example = "Juan Carlos")
        @NotBlank String name,

        @Schema(description = "Primer apellido del solicitante", example = "Pérez")
        @NotBlank String firstSurname,

        @Schema(description = "Segundo apellido del solicitante (opcional)", example = "García")
        String secondSurname,

        @Schema(description = "CURP del solicitante", example = "PEGA900101HDFRRL09")
        @Pattern(regexp = "^[A-Z]{4}[0-9]{6}[A-Z]{6}[0-9]{2}$", message = "CURP inválido") String curp,

        @Schema(description = "Fecha de nacimiento del solicitante", example = "2000-01-01")
        @NotNull LocalDate birthDate,

        @Schema(description = "Género del solicitante (MASCULINO, FEMENINO, OTRO)", examples = {"MASCULINO", "FEMENINO", "OTRO"})
        @NotNull Gender gender,

        @Schema(description = "ID de la nacionalidad del solicitante", example = "1")
        @NotNull Long nationalityId,

        @Schema(description = "ID del estado civil del solicitante", example = "2")
        @NotNull Long maritalStatusId,

        @Schema(description = "ID del lenguaje natal del solicitante", example = "3")
        @NotNull Long nativeLanguageId,

        @Schema(description = "¿El solicitante tiene hijos?", example = "true")
        @NotNull Boolean hasChildren,

        @Schema(description = "Correo electrónico del solicitante", example = "usuario@dominio.com")
        @NotBlank
        @Email(message = "Correo electrónico inválido") String email,
        
        @Schema(description = "ID del país en done nació" , example = "1")
        @NotNull Long countryId,

        @Schema(description = "ID del estado en donde nació", example = "12")
        @NotNull Long birthStateId,

        @Schema(description = "ID del municipio en donde nació", example = "34")
        @NotNull Long birthMunicipalityId,

        @Schema(description = "Ciudad de nacimiento del solicitante", example = "Ciudad de México")
        @NotBlank String birthCity

) {
}
