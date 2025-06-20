package utez.edu.mx.fichas_utez_backend.Modules.Registration.Controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Schema(name = "AddressRequest", description = "Domicilio del solicitante")
public record AddressRequest(
    @Schema(description = "Calle del domicilio", example = "Av. Reforma")
    @NotBlank String street,

    @Schema(description = "Número exterior", example = "123")
    @NotBlank String exteriorNumber,

    @Schema(description = "Número interior (opcional)", example = "4B")
    String interiorNumber,

    @Schema(description = "Colonia", example = "Centro")
    @NotBlank String neighborhood,

    @Schema(description = "Localidad", example = "Cuernavaca")
    @NotBlank String locality,

    @Schema(description = "ID del estado", example = "17")
    @NotNull Long stateId,

    @Schema(description = "ID del municipio", example = "23")
    @NotNull Long municipalityId,

    @Schema(description = "Código postal", example = "62000")
    @Pattern(message = "El código postal debe tener 5 dígitos", regexp = "^[0-9]{5}$")
    String postalCode
) {}

