package football.team.management.footballTeamManagement.service;

import football.team.management.footballTeamManagement.dto.FootballTeamDtoIn;
import football.team.management.footballTeamManagement.entity.FootballTeam;

import java.util.List;

public interface FootballTeamService {

    List<FootballTeam> getAllTeams();

    FootballTeam getTeamById(Long id);

    List<FootballTeam> getTeamsByName(String name);

    FootballTeam createTeam(FootballTeamDtoIn footballTeamDtoIn);

    FootballTeam updateTeam(Long id, FootballTeamDtoIn footballTeamDtoIn);

    void deleteTeam(Long id);
}
