package utez.edu.mx.fichas_utez_backend.Modules.Registration.Controller.dto.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import utez.edu.mx.fichas_utez_backend.Modules.Registration.Controller.dto.WorkIncomeInfoRequest;

public class WorkFieldsIfEmployedValidator implements ConstraintValidator<ValidWorkFieldsIfEmployed, WorkIncomeInfoRequest> {
    @Override
    public boolean isValid(WorkIncomeInfoRequest value, ConstraintValidatorContext context) {
        if (value == null) return true;
        if (Boolean.TRUE.equals(value.isCurrentlyEmployed())) {
            boolean valid = value.employmentType() != null
                    && value.companyName() != null && !value.companyName().isBlank()
                    && value.jobPosition() != null && !value.jobPosition().isBlank()
                    && value.monthlyIncome() != null
                    && value.workSchedule() != null && !value.workSchedule().isBlank()
                    && value.companyLada() != null && !value.companyLada().isBlank()
                    && value.companyPhoneNumber() != null && !value.companyPhoneNumber().isBlank();
            if (!valid) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("Todos los datos de trabajo son obligatorios si la persona trabaja actualmente.")
                        .addConstraintViolation();
            }
            return valid;
        }
        return true;
    }
}

