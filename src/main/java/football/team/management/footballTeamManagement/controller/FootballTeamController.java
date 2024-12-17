package football.team.management.footballTeamManagement.controller;

import football.team.management.footballTeamManagement.entity.FootballTeam;
import football.team.management.footballTeamManagement.service.FootballTeamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @Autowired
    public void setFootballTeamService(FootballTeamService footballTeamService) {
        this.footballTeamService = footballTeamService;
    }
}
