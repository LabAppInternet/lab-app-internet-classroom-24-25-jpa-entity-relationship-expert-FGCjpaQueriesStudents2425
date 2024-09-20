package cat.tecnocampus.fgcstations.application.exception;

public class JourneyDoesNotExistsException extends RuntimeException {
    public JourneyDoesNotExistsException(String origin, String destination) {
        super("Journey from " + origin + " to " + destination + " does not exists");
    }
}
