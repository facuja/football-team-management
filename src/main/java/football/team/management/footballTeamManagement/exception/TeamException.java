package football.team.management.footballTeamManagement.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamException extends RuntimeException{

    private final String description;
    private final Long code;


    public TeamException(String description, Long code) {
        super(description);
        this.description = description;
        this.code = code;
    }
}
