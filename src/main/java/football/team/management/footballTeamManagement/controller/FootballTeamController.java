package football.team.management.footballTeamManagement.controller;

import football.team.management.footballTeamManagement.dto.FootballTeamDtoIn;
import football.team.management.footballTeamManagement.entity.FootballTeam;
import football.team.management.footballTeamManagement.service.FootballTeamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class FootballTeamController {

    FootballTeamService footballTeamService;
    private static final Logger LOGGER = LoggerFactory.getLogger(FootballTeamController.class);

    @Operation(summary = "Obtener todos los equipos", description = "Devuelve la lista de equipos registrados")
    @GetMapping(value = "equipos")
    public ResponseEntity<List<FootballTeam>> getAllTeams() {

        LOGGER.info("Método getAllTeams()");

        List<FootballTeam> teams = footballTeamService.getAllTeams();
        return ResponseEntity.ok()
                .body(teams);
    }

    @Operation(summary = "Obtener un equipo", description = "Devuelve un equipo por id")
    @GetMapping(value = "equipos/{id}")
    public ResponseEntity<FootballTeam> getTeamById(
            @Parameter(in = ParameterIn.PATH, description = "Team id", example = "1", required = true)
            @PathVariable(name = "id") Long id) {

        LOGGER.info("Método getTeamById() para el equipo ID: {}", id);

        FootballTeam team = footballTeamService.getTeamById(id);
        return ResponseEntity
                .ok()
                .body(team);
    }


    @Operation(summary = "Obtener quipos por nombre", description = "Devuelve una lista de equipos por nombre")
    @GetMapping(value = "equipos/buscar")
    public ResponseEntity<List<FootballTeam>> getTeamsByName(
            @Parameter(in = ParameterIn.QUERY, description = "Team name", example = "Barcelona", required = true)
            @RequestParam("nombre") String name) {

        LOGGER.info("Método getTeamsByName() - buscar con nombre: {}", name);

        List<FootballTeam> teams = footballTeamService.getTeamsByName(name);
        return ResponseEntity
                .ok()
                .body(teams);
    }

    @Operation(summary = "Crear un equipo", description = "Permite la creación de un nuevo equipo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    @PostMapping(value = "equipos")
    public ResponseEntity<FootballTeam> createTeam(@RequestBody @Valid FootballTeamDtoIn footballTeamDtoIn){

        LOGGER.info("Método createTeam()");

        FootballTeam createdTeam = footballTeamService.createTeam(footballTeamDtoIn);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTeam);
    }

    @Operation(summary = "Actualizar un equipo", description = "Permite la actualización de un equipo")
    @PutMapping(value = "equipos/{id}")
    public ResponseEntity<FootballTeam> updateTeam(
            @RequestBody @Valid FootballTeamDtoIn footballTeamDtoIn,
            @Parameter(in = ParameterIn.PATH, description = "Team Id", example = "1", required = true)
            @PathVariable(name = "id") Long id) {

        LOGGER.info("Metodo updateTeam para el equipo ID: {}", id);

        FootballTeam updatedTeam = footballTeamService.updateTeam(id, footballTeamDtoIn);
        return ResponseEntity.ok(updatedTeam);
    }


    @Operation(summary = "Eliminar equipo", description = "Permite la eliminación de un equipo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No Content")
    })
    @DeleteMapping(value = "equipos/{id}")
    public ResponseEntity<Void> deleteTeam(
            @Parameter(in = ParameterIn.PATH, description = "Team Id", example = "1", required = true)
            @PathVariable Long id) {

        LOGGER.info("Método deleteTeam() para ID: {}", id);

        footballTeamService.deleteTeam(id);
        return ResponseEntity.noContent().build();
    }


    @Autowired
    public void setFootballTeamService(FootballTeamService footballTeamService) {
        this.footballTeamService = footballTeamService;
    }
}
