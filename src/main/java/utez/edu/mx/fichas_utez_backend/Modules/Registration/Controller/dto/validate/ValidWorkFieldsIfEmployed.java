package utez.edu.mx.fichas_utez_backend.Modules.Registration.Controller.dto.validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = WorkFieldsIfEmployedValidator.class)
@Target({ TYPE })
@Retention(RUNTIME)
public @interface ValidWorkFieldsIfEmployed {
    String message() default "Los datos de trabajo son obligatorios si la persona trabaja actualmente.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

