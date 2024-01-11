package exceptions;

public class FrameworkException extends RuntimeException {
    public FrameworkException(final String message, final Exception e) {
        super(message, e);
    }
}
