package pt.brunojesus.locationsearch.exception;

/**
 * Exception to be thrown when the application is not able to retrieve the location list from the external source
 *
 * @author Bruno Jesus
 * @version 1.0
 * @since 2023-05-11
 */
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
