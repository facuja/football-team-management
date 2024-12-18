package football.team.management.footballTeamManagement.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    NOT_FOUND_TEAM("Equipo no encontrado.", 404L),
    EXISTING_TEAM("El nombre del equipo ya existe", 404L),
    INVALID_CREDENTIALS("Credenciales inválidas.", 401L);
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
