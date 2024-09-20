package cat.tecnocampus.fgcstations.application.exception;

public class StationDoesNotExistsException extends RuntimeException {
    public StationDoesNotExistsException(String name) {
        super("Station " + name + " does not exist.");
    }
}
