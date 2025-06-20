package utez.edu.mx.fichas_utez_backend.kernel;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Validations {
    public boolean isInvalidEmail(String email){
        return !email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    }

    public boolean isInvalidPhone(Long phone){
        return !String.valueOf(phone).matches("^[0-9]{1,10}$");
    }

    public boolean isInvalidPostalCode(String zipCode) {
        return !zipCode.matches("^[\"']?\\d{5}[\"']?$");
    }

    public boolean isInvalidStreet(String street){
        return !street.matches("^[a-zA-Z0-9\\sáéíóúÁÉÍÓÚñÑüÜ.,'-]{3,100}$");
    }

    public static boolean isNotDecimal(double number) {
        return number != Math.floor(number);
    }
    
    // Validación de CURP (formato oficial mexicano)
    public boolean isInvalidCurp(String curp) {
        return !curp.matches("^[A-Z]{4}[0-9]{6}[HM][A-Z]{5}[0-9A-Z][0-9]$");
    }

    // Validación de nombres con acentos y ñ
    public boolean isInvalidName(String name) {
        return !name.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]{3,}$");
    }

    // Validación de edad a partir de fecha de nacimiento
    public boolean isInvalidAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears() < 15;
    }

    // Sobrecarga para validar edad con Date
    public boolean isInvalidAge(Date birthDate) {
        return isInvalidAge(birthDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate());
    }

    // Validación de lada (3 dígitos)
    public boolean isInvalidLada(String lada) {
        return !lada.matches("^[0-9]{3}$");
    }

    // Validación de promedio escolar
    public boolean isInvalidPromedio(double promedio) {
        return promedio < 6.0 || promedio > 10.0 || 
               Double.toString(promedio).matches(".*\\..*[0-9]{3,}");
    }

    // Validación de Clave CCT (Centro de Trabajo)
    public boolean isInvalidClaveCCT(String claveCCT) {
        return !claveCCT.matches("^[0-9A-Z]{10}$");
    }

    // Validación de nombre de empresa
    public boolean isInvalidCompanyName(String companyName) {
        return !companyName.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]{5,50}$");
    }

    // Validación de puesto
    public boolean isInvalidPuesto(String puesto) {
        return !puesto.matches("^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑüÜ\\s]{1,50}$");
    }

    // Validación de formato horario
    public boolean isInvalidHorario(String horario) {
        return !horario.matches("^([0-1]?[0-9]|2[0-3]):[0-5][0-9]\\s*-\\s*([0-1]?[0-9]|2[0-3]):[0-5][0-9]$");
    }

    // Validación genérica para selects requeridos
    public boolean isInvalidSelect(String value) {
        return value == null || value.trim().isEmpty();
    }

    // Validación para input dependiente de select
    public boolean isInvalidDependentInput(String selectValue, String inputValue, String triggerValue) {
        return selectValue.equals(triggerValue) && (inputValue == null || inputValue.trim().isEmpty());
    }

    // Sobrecarga para casos comunes de "Otro" u "Otra"
    public boolean isInvalidDependentInput(String selectValue, String inputValue) {
        return isInvalidDependentInput(selectValue, inputValue, "Otro") || 
               isInvalidDependentInput(selectValue, inputValue, "Otra");
    }
}