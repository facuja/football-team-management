package football.team.management.footballTeamManagement.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "EQUIPOS")
@Entity
@Data
public class FootballTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String liga;
    private String pais;
}
