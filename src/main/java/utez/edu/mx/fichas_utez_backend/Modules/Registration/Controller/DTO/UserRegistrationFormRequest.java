package utez.edu.mx.fichas_utez_backend.Modules.Registration.Controller.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record UserRegistrationFormRequest(
        @NotNull @Valid PersonalDataRequest personalData,
        @NotNull @Valid AddressUserRequest address,
        @NotNull @Valid ComplementaryInfoRequest complementaryInfo,
        @NotNull @Valid WorkIncomeInfoRequest workIncomeInfo,
        @NotNull @Valid AcademicCareerRequest academicCareer,
        @NotNull @Valid HighSchoolBackgroundRequest highSchoolBackground
) {}
