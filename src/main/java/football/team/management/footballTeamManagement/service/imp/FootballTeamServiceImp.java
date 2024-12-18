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

        return validExistingTeamById(id);
    }

    @Override
    public List<FootballTeam> getTeamsByName(String name) {
        LOGGER.info("Metodo getTeamByName()");

        List<FootballTeam> teams = footballTeamRepository.findByNombreContainsIgnoreCase(name);

        if(teams.isEmpty()){
            throw new TeamException(
                    ErrorCode.NOT_FOUND_TEAM.getDescription(),
                    ErrorCode.NOT_FOUND_TEAM.getCode()
            );
        }
        return teams;

    }

    @Override
    public FootballTeam createTeam(FootballTeamDtoIn footballTeamDtoIn) {
        LOGGER.info("Metodo createTeam()");

        validNotExistingTeamByName(footballTeamDtoIn.getNombre());

        FootballTeam newTeam = new FootballTeam();
        newTeam.setNombre(footballTeamDtoIn.getNombre());
        newTeam.setLiga(footballTeamDtoIn.getLiga());
        newTeam.setPais(footballTeamDtoIn.getPais());

        return footballTeamRepository.save(newTeam);
    }

    @Override
    public FootballTeam updateTeam(Long id, FootballTeamDtoIn footballTeamDtoIn) {
        LOGGER.info("Metodo updateTeam()");

        validNotExistingTeamByName(footballTeamDtoIn.getNombre());

        FootballTeam existingTeam = validExistingTeamById(id);
        existingTeam.setNombre(footballTeamDtoIn.getNombre());
        existingTeam.setLiga(footballTeamDtoIn.getLiga());
        existingTeam.setPais(footballTeamDtoIn.getPais());

        return footballTeamRepository.save(existingTeam);
    }

    @Override
    public void deleteTeam(Long id) {
        LOGGER.info("Metodo deleteTeam()");

        FootballTeam existingTeam = validExistingTeamById(id);
        footballTeamRepository.delete(existingTeam);
    }

    private FootballTeam validExistingTeamById(Long id){
        return footballTeamRepository
                .findById(id)
                .orElseThrow(() -> new TeamException(
                        ErrorCode.NOT_FOUND_TEAM.getDescription(),
                        ErrorCode.NOT_FOUND_TEAM.getCode()
                ));
    }

    private void validNotExistingTeamByName(String name){
        FootballTeam existingTeam = footballTeamRepository.findByNombreIgnoreCase(name);
        if (existingTeam != null) {
            throw new TeamException(
                    ErrorCode.EXISTING_TEAM.getDescription(),
                    ErrorCode.EXISTING_TEAM.getCode());
        }
    }


    @Autowired
    public void setFootballTeamRepository(FootballTeamRepository footballTeamRepository) {
        this.footballTeamRepository = footballTeamRepository;
    }
}
