package football.team.management.footballTeamManagement.repository;

import football.team.management.footballTeamManagement.entity.FootballTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FootballTeamRepository extends JpaRepository<FootballTeam, Long> {
}
