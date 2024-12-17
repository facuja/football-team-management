package football.team.management.footballTeamManagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonIgnoreProperties("id")
public class FootballTeamDtoIn {

    private Long id;

    @NotNull(message = "Nombre requerido")
    @NotBlank(message = "Nombre requerido")
    @Schema(name = "name", example = "Juventus FC")
    private String name;

    @NotNull(message = "Liga requerida")
    @NotBlank(message = "Liga requerida")
    @Schema(name = "league", example = "Serie A")
    private String league;

    @NotNull(message = "Pais requerido")
    @NotBlank(message = "Pais requerido")
    @Schema(name = "country", example = "Italia")
    private String country;
}
