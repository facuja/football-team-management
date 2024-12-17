package football.team.management.footballTeamManagement.service.imp;

import football.team.management.footballTeamManagement.dto.FootballTeamDtoIn;
import football.team.management.footballTeamManagement.entity.FootballTeam;
import football.team.management.footballTeamManagement.exception.ErrorCode;
import football.team.management.footballTeamManagement.exception.TeamException;
import football.team.management.footballTeamManagement.repository.FootballTeamRepository;
import football.team.management.footballTeamManagement.service.FootballTeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootballTeamServiceImp implements FootballTeamService {

    FootballTeamRepository footballTeamRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(FootballTeamServiceImp.class);

    @Override
    public List<FootballTeam> getAllTeams() {
        LOGGER.info("Metodo getAllTeams()");
        try {
            return footballTeamRepository.findAll();
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error al acceder a la base de datos", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error inesperado", ex);
        }
    }

    @Override
    public FootballTeam getTeamById(Long id) {
        LOGGER.info("Metodo getTeamById()");
        return footballTeamRepository
                .findById(id)
                .orElseThrow(() -> new TeamException(
                        ErrorCode.NOT_FOUND_TEAM.getDescription(),
                        ErrorCode.NOT_FOUND_TEAM.getCode()
                ));
    }

    @Override
    public FootballTeam getTeamByName(String name) {
        return null;
    }

    @Override
    public FootballTeam createTeam(FootballTeamDtoIn footballTeamDtoIn) {
        return null;
    }

    @Override
    public FootballTeam updateTeam(Long id, FootballTeamDtoIn footballTeamDtoIn) {
        return null;
    }

    @Override
    public void deleteTeam(Long id) {

    }



    @Autowired
    public void setFootballTeamRepository(FootballTeamRepository footballTeamRepository) {
        this.footballTeamRepository = footballTeamRepository;
    }
}
