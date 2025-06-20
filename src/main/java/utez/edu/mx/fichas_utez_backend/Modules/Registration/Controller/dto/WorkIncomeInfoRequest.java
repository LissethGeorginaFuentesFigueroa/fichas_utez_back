package utez.edu.mx.fichas_utez_backend.Modules.Registration.Controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import utez.edu.mx.fichas_utez_backend.Modules.Registration.Controller.dto.enums.EmploymentType;

@Schema(name = "WorkIncomeInfoRequest", description = "Información de ingresos y trabajo de la persona")
public record WorkIncomeInfoRequest(

        @Schema(description = "Ingreso familiar mensual en pesos mexicanos", example = "8000.00")
        @NotNull @PositiveOrZero Double familyMonthlyIncome,

        @Schema(description = "¿La persona trabaja actualmente?", example = "true")
        @NotNull Boolean isCurrentlyEmployed,

        /* Datos del trabajo si aplica*/

        @Schema(description = "Tipo de empleo (TEMPORAL, PERMANENTE) si aplica", example = "PERMANENTE")
        EmploymentType employmentType,

        @Schema(description = "Nombre de la empresa donde trabaja si aplica", example = "Empresa XYZ")
        String companyName,

        @Schema(description = "Puesto que ocupa en la empresa si aplica", example = "Desarrollador de software")
        String jobTitle,

        @Schema(description = "Ingreso mensual en pesos mexicanos si aplica", example = "15000.00")
        @PositiveOrZero Double monthlyIncome,

        @Schema(description = "Horario de trabajo (ejemplo: 9:00 - 18:00) si aplica", example = "9:00 - 18:00")
        String workSchedule,

        @Schema(description = "Lada telefónica de la empresa si aplica", example = "55-1234-5678")
        String companyPhone,

        @Schema(description = "Teléfono de la empresa", example = "12345678")
        @NotNull String companyPhoneNumber

) {
}
