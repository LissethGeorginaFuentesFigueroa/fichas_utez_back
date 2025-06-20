package utez.edu.mx.fichas_utez_backend.kernel;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Respuesta API es una clase genérica que representa la estructura de la respuesta de la API.")
public class ResponseApi<T> {

    @Schema(description = "code of the response", example = "200")
    private int code;

    @Schema(description = "message to the user to explain the response", example = "Success")
    private String message;

    @Schema(description = "data of the response")
    private T data;

    @Schema(description = "if the response is an error", example = "false")
    private boolean error;

    @Schema(description = "error message")
    private List<String> errors;

    public ResponseApi(List<String> errors, int status) {
        this.code = status;
        this.error = status >= 400;
        this.errors = errors;
        this.message = error ? "ERROR" : "SUCCESS";
    }

    public ResponseApi(int status, String message) {
        this.code = status;
        this.error = status >= 400;
        this.message = message;
    }

    public ResponseApi(T data, int status) {
        this.code = status;
        this.error = status >= 400;
        this.data = data;
        this.message = error ? "ERROR" : "SUCCESS";
    }

    public ResponseApi(T data, int value, String message) {
        this.code = value;
        this.error = value >= 400;
        this.data = data;
        this.message = message;
    }
    // Mejoras sugeridas:
    // 1. Constructor estático para respuestas exitosas
    public static <T> ResponseApi<T> success(T data) {
        return new ResponseApi<>(data, 200);
    }

    // 2. Constructor estático para errores
    public static <T> ResponseApi<T> error(List<String> errors, int status) {
        return new ResponseApi<>(errors, status);
    }

    // 3. Permitir agregar errores de forma fluida
    public ResponseApi<T> addError(String errorMsg) {
        if (this.errors == null) {
            this.errors = new java.util.ArrayList<>();
        }
        this.errors.add(errorMsg);
        this.error = true;
        return this;
    }

    // Response created
    public static <T> ResponseApi<T> created(T data) {
        return new ResponseApi<>(data, HttpStatus.CREATED.value(), "Resource created successfully");
    }
}
