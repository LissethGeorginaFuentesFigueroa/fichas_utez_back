package utez.edu.mx.fichas_utez_backend.kernel;

public enum ErrorMessages {

    // ----------- 🔴 CAMPOS OBLIGATORIOS (400) -----------

    MISSING_NAME,                         // El nombre no fue proporcionado
    MISSING_FIRST_LASTNAME,              // Apellido paterno faltante
    MISSING_CURP,                        // CURP no proporcionado
    MISSING_BIRTHDATE,                   // Fecha de nacimiento vacía
    MISSING_GENDER,                      // Sexo no seleccionado
    MISSING_NATIONALITY,                 // Nacionalidad no proporcionada
    MISSING_STATE,                       // Estado requerido pero no enviado
    MISSING_MUNICIPALITY,               // Municipio requerido pero no enviado
    MISSING_COUNTRY,                     // País requerido (si extranjera)
    MISSING_CITY,                        // Ciudad requerida (si extranjera)
    MISSING_MARITAL_STATUS,              // Estado civil no seleccionado
    MISSING_NATIVE_LANGUAGE,             // Lengua natal no seleccionada
    MISSING_HAS_CHILDREN,                // Falta indicar si tiene hijos
    MISSING_STREET,                      // Calle no proporcionada
    MISSING_EXTERNAL_NUMBER,             // Número exterior faltante
    MISSING_COLONY,                      // Colonia no proporcionada
    MISSING_LOCALITY,                    // Localidad no proporcionada
    MISSING_POSTAL_CODE,                 // Código postal faltante
    MISSING_EMAIL,                       // Email vacío
    MISSING_DISABILITIES,                // Discapacidad no seleccionada
    MISSING_INDIGENOUS_LANGUAGES_FAMILY, // Lenguas indígenas de padres no proporcionadas
    MISSING_SPOKEN_INDIGENOUS_LANGUAGES, // Lenguas indígenas habladas no proporcionadas
    MISSING_FAMILY_INCOME,               // Ingreso familiar mensual vacío
    MISSING_EMPLOYMENT_STATUS,           // No indicó si trabaja
    MISSING_WORK_TYPE,                   // No seleccionó si el trabajo es temporal o permanente
    MISSING_LADA,                        // Lada del teléfono no enviada
    MISSING_PHONE,                       // Teléfono no proporcionado
    MISSING_MONTHLY_INCOME,              // Ingreso mensual no especificado
    MISSING_COMPANY_NAME,                // Falta nombre de la empresa
    MISSING_JOB_TITLE,                   // Puesto no especificado
    MISSING_SCHEDULE,                    // Horario no proporcionado
    MISSING_CAREER,                      // Carrera de interés no seleccionada
    MISSING_MEDIA_SOURCE,                // Medio por el cual conoció la UTEZ no indicado
    MISSING_U_TEZ_RELATION,              // Relación con la UTEZ no especificada
    MISSING_HIGHSCHOOL_TYPE,             // Tipo de prepa no seleccionado
    MISSING_HIGHSCHOOL_NAME,             // Nombre de prepa no proporcionado
    MISSING_CCT,                         // Clave CCT no enviada
    MISSING_PROMEDIO,                    // Promedio no ingresado
    MISSING_HAS_SCHOLARSHIP,             // No indicó si tiene beca
    MISSING_SCHOLARSHIP_NAME,            // Nombre de beca no proporcionado (si aplica)

    // ----------- ❌ CAMPOS INVÁLIDOS (400) -----------

    INVALID_NAME,                        // Nombre inválido (por formato)
    INVALID_FIRST_LASTNAME,             // Apellido paterno inválido
    INVALID_SECOND_LASTNAME,            // Apellido materno inválido
    INVALID_CURP,                        // CURP mal formado o no válido
    INVALID_DATE,                        // Fecha con formato incorrecto
    INVALID_AGE,                         // Edad inválida (por debajo del mínimo permitido)
    INVALID_GENDER,                      // Sexo no válido
    INVALID_NATIONALITY,                // Nacionalidad inválida
    INVALID_STATE,                       // Estado no válido
    INVALID_MUNICIPALITY,              // Municipio no válido
    INVALID_COUNTRY,                     // País no válido
    INVALID_CITY,                        // Ciudad no válida
    INVALID_MARITAL_STATUS,              // Estado civil inválido
    INVALID_NATIVE_LANGUAGE,             // Lengua natal con formato inválido
    INVALID_BOOLEAN_OPTION,              // Opción de sí/no no válida
    INVALID_STREET,                      // Calle con caracteres inválidos
    INVALID_POSTAL_CODE,                 // CP mal formado
    INVALID_COLONY,                      // Colonia con caracteres inválidos
    INVALID_LOCALITY,                    // Localidad inválida
    INVALID_EMAIL,                       // Email no válido según patrón RFC
    INVALID_PHONE,                       // Teléfono con formato incorrecto
    INVALID_LADA,                        // Lada con longitud incorrecta
    INVALID_FAMILY_INCOME,               // Ingreso familiar fuera de rango permitido
    INVALID_WORK_TYPE,                   // Tipo de trabajo no válido
    INVALID_COMPANY_NAME,                // Nombre de empresa con caracteres inválidos
    INVALID_JOB_TITLE,                   // Puesto con formato incorrecto
    INVALID_SCHEDULE,                    // Horario con formato incorrecto (ej. "7:00 - 15:00")
    INVALID_MONTHLY_INCOME,              // Ingreso mensual inválido
    INVALID_CAREER,                      // Carrera no válida
    INVALID_MEDIA_SOURCE,                // Medio no válido
    INVALID_U_TEZ_RELATION,              // Relación con UTEZ inválida
    INVALID_HIGHSCHOOL_TYPE,             // Tipo de prepa inválido
    INVALID_HIGHSCHOOL_NAME,             // Nombre de prepa con caracteres inválidos
    INVALID_CCT,                         // Clave CCT no cumple con patrón
    INVALID_PROMEDIO,                    // Promedio fuera del rango (6.0 - 10.0)
    INVALID_SCHOLARSHIP_NAME,            // Nombre de beca inválido

    // ----------- 📎 CAMPOS DEPENDIENTES -----------

    MISSING_OTHER_COUNTRY_NAME,         // Falta campo de país si selecciona "Otro"
    MISSING_OTHER_STATE_NAME,           // Falta campo de estado si selecciona "Otro"
    MISSING_OTHER_CITY_NAME,            // Falta campo de ciudad si selecciona "Otro"
    MISSING_OTHER_NATIVE_LANGUAGE,      // Falta campo de lengua si selecciona "Otra"
    MISSING_OTHER_DISABILITY,           // Falta especificar discapacidad si selecciona "Otra"
    MISSING_OTHER_INDIGENOUS_LANGUAGE,  // Falta especificar lengua indígena si selecciona "Otra"
    MISSING_OTHER_MEDIA_SOURCE,         // Falta especificar medio si selecciona "Otro"
    MISSING_OTHER_U_TEZ_RELATION,       // Falta explicar relación si selecciona "Otra"
    MISSING_OTHER_HIGHSCHOOL_TYPE,      // Falta indicar tipo de prepa si selecciona "Otra"

    INVALID_OTHER_COUNTRY_NAME,         // Campo de país alterno inválido
    INVALID_OTHER_STATE_NAME,           // Campo de estado alterno inválido
    INVALID_OTHER_CITY_NAME,            // Ciudad alterna inválida
    INVALID_OTHER_NATIVE_LANGUAGE,      // Lengua alterna inválida
    INVALID_OTHER_DISABILITY,           // Discapacidad alterna inválida
    INVALID_OTHER_INDIGENOUS_LANGUAGE,  // Lengua indígena alterna inválida
    INVALID_OTHER_MEDIA_SOURCE,         // Medio alterno inválido
    INVALID_OTHER_U_TEZ_RELATION,       // Relación alterna inválida
    INVALID_OTHER_HIGHSCHOOL_TYPE,      // Prepa alterna inválida

    // ----------- ⚠️ LÓGICA DE NEGOCIO / CONFLICTOS -----------

    CURP_ALREADY_EXISTS,                // CURP ya registrada
    EMAIL_ALREADY_EXISTS,               // Email ya en uso
    CCT_ALREADY_EXISTS,                 // Clave CCT duplicada

    AGE_UNDER_15,                       // Edad menor a la mínima permitida
    INVALID_DATE_FORMAT,                // Fecha mal formateada
    INVALID_AVERAGE_RANGE,              // Promedio fuera del rango 6.0-10.0
    SELECT_OPTION_REQUIRED,             // Select obligatorio sin opción válida
    DEPENDENT_FIELD_REQUIRED,           // Campo dependiente no completado
    INVALID_DEPENDENT_SELECT_COMBINATION // Combinación inválida de selects dependientes
}

