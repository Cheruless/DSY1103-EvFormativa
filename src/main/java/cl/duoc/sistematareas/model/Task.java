package cl.duoc.sistematareas.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* Tuve problemas para ejecutar post. Se resolvió al eliminar:
*   @NoArgsConstructor y @AllArgsConstructor
* Error:
*   WARN 6586 --- [EV Formativa] [nio-8080-exec-2] .w.s.m.s.DefaultHandlerExceptionResolver : Resolved [org.springframework.http.converter.HttpMessageNotReadableException: JSON parse error: Cannot map `null` into type `int` (set `DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES` to 'false' to allow)]
 * */
@Data
public class Task {

    private int id;
    @NotBlank(message = "Título es obligatorio.")
    private String title;
    @NotBlank(message = "Descripción es obligatorio.")
    private String description;
    private boolean completed;
}
