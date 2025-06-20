package utez.edu.mx.fichas_utez_backend.Modules.Registration.Controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(name = "ComplementaryInfoRequest", description = "Información complementaria de la persona")
public record ComplementaryInfoRequest(
    @Schema(description = "Lista de IDs de discapacidades si la persona tiene alguna (opcional, puede ser null o vacío)", example = "[1, 2]")
    List<Long> disabilityIds,

    @Schema(description = "Lista de IDs de lenguas indígenas que hablan los padres si aplica (opcional, puede ser null o vacío)", example = "[5, 7]")
    List<Long> parentsIndigenousLanguageIds,

    @Schema(description = "Lista de IDs de lenguas indígenas que habla la persona si aplica (opcional, puede ser null o vacío)", example = "[3, 8]")
    List<Long> indigenousLanguageIds
) {}
