package pt.brunojesus.locationsearch.exception;

public class LocationSearchException extends Exception {

    public LocationSearchException() {
    }

    public LocationSearchException(String message) {
        super(message);
    }

    public LocationSearchException(String message, Throwable cause) {
        super(message, cause);
    }

    public LocationSearchException(Throwable cause) {
        super(cause);
    }

    public LocationSearchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
