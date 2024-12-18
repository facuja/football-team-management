package football.team.management.footballTeamManagement.service.utils;

import football.team.management.footballTeamManagement.dto.FootballTeamDtoIn;
import football.team.management.footballTeamManagement.entity.FootballTeam;

import java.util.Arrays;
import java.util.List;

public class TestUtil {

    public List<FootballTeam> getAllTeams(){
        FootballTeam team1 = new FootballTeam();
        team1.setId(1L);
        team1.setNombre("Barcelona");
        team1.setLiga("La Liga");
        team1.setPais("España");

        FootballTeam team2 = new FootballTeam();
        team2.setId(2L);
        team2.setNombre("Juventus");
        team2.setLiga("Serie A");
        team2.setPais("Italia");

        return Arrays.asList(team1, team2);
    }

    public FootballTeam getTeam(){
        FootballTeam team = new FootballTeam();
        team.setId(1L);
        team.setNombre("Barcelona");
        team.setLiga("La Liga");
        team.setPais("España");

        return team;
    }

    public FootballTeamDtoIn createTeam(){
        FootballTeamDtoIn createTeam = new FootballTeamDtoIn();
        createTeam.setNombre("Barcelona");
        createTeam.setLiga("La Liga");
        createTeam.setPais("España");

        return createTeam;
    }

}
