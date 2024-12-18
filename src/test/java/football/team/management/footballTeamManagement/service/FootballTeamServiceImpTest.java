package football.team.management.footballTeamManagement.service;

import football.team.management.footballTeamManagement.entity.FootballTeam;
import football.team.management.footballTeamManagement.repository.FootballTeamRepository;
import football.team.management.footballTeamManagement.service.imp.FootballTeamServiceImp;
import football.team.management.footballTeamManagement.service.utils.TestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FootballTeamServiceImpTest extends TestUtil {

    @Mock
    private FootballTeamRepository footballTeamRepository;

    @InjectMocks
    private FootballTeamServiceImp footballTeamService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testGetAllTeams() {
        when(footballTeamRepository.findAll()).thenReturn(getAllTeams());

        List<FootballTeam> teams = footballTeamService.getAllTeams();

        assertNotNull(teams);
        assertFalse(teams.isEmpty());
        assertEquals(2, teams.size());
        assertEquals("Barcelona", teams.get(0).getNombre());
    }

    @Test
    void testGetTeamById() {
        when(footballTeamRepository.findById(1L)).thenReturn(Optional.of(getTeam()));

        FootballTeam team = footballTeamService.getTeamById(1L);

        assertNotNull(team);
        assertEquals("Barcelona", team.getNombre());
    }


    @Test
    void testCreateTeam() {
        when(footballTeamRepository.save(any(FootballTeam.class))).thenReturn(getTeam());

        FootballTeam createdTeam = footballTeamService.createTeam(createTeam());

        assertNotNull(createdTeam);
        assertEquals("Barcelona", createdTeam.getNombre());
        assertEquals("España", createdTeam.getPais());
    }

    @Test
    void testUpdateTeam() {
        when(footballTeamRepository.findById(1L)).thenReturn(Optional.of(getTeam()));
        when(footballTeamRepository.save(any(FootballTeam.class))).thenReturn(getTeam());

        FootballTeam updatedTeam = footballTeamService.updateTeam(1L, createTeam());

        assertNotNull(updatedTeam);
        assertEquals(1L, updatedTeam.getId());
        assertEquals("La Liga", updatedTeam.getLiga());
    }

    @Test
    void testDeleteTeam() {
        when(footballTeamRepository.findById(1L)).thenReturn(Optional.of(getTeam()));

        footballTeamService.deleteTeam(1L);

        verify(footballTeamRepository, times(1)).delete(getTeam());
    }

}
