package football.team.management.footballTeamManagement.exception;

public class InvalidCredentialsException extends RuntimeException{
    private final Long code;

    public InvalidCredentialsException(String message, Long code) {
        super(message);
        this.code = code;
    }

    public Long getCode() {
        return code;
    }
}
