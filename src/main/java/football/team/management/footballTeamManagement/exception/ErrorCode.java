package football.team.management.footballTeamManagement.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    NOT_FOUND_TEAM("Equipo no encontrado.", 404L);
    private final String description;
    private final Long code;

    ErrorCode(String description, Long code) {
        this.description = description;
        this.code = code;
    }

    @Override
    public String toString() {
        return  description + ": " + code ;
    }
}
