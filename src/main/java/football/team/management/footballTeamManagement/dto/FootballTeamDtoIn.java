package football.team.management.footballTeamManagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@JsonIgnoreProperties("id")
public class FootballTeamDtoIn {

    private Long id;

    @NotBlank(message = "Nombre requerido")
    @Schema(name = "nombre", example = "Juventus FC")
    private String nombre;

    @NotBlank(message = "Liga requerida")
    @Schema(name = "liga", example = "Serie A")
    private String liga;

    @NotBlank(message = "Pais requerido")
    @Schema(name = "pais", example = "Italia")
    private String pais;
}
