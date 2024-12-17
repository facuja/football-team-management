package football.team.management.footballTeamManagement.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "EQUIPOS")
@Entity
@Data
public class footballTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NOMBRE")
    private String name;

    @Column(name = "LIGA")
    private String league;

    @Column(name = "PAIS")
    private String country;
}
