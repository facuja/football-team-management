package football.team.management.footballTeamManagement.repository;

import football.team.management.footballTeamManagement.entity.FootballTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FootballTeamRepository extends JpaRepository<FootballTeam, Long> {
    List<FootballTeam> findByNombreContainsIgnoreCase(String name);
    FootballTeam findByNombreIgnoreCase(String name);
}
