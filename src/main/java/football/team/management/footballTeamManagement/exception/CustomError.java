package football.team.management.footballTeamManagement.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class CustomError {
    @JsonIgnore
    private HttpStatus status;
    private String mensaje;
    private Long codigo;


    public CustomError(HttpStatus status,String mensaje, Long codigo) {
        this.status = status;
        this.mensaje = mensaje;
        this.codigo = codigo;
    }
}
