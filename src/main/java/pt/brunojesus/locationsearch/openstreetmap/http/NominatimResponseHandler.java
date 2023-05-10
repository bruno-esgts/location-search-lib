package pt.brunojesus.locationsearch.openstreetmap.http;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import pt.brunojesus.locationsearch.openstreetmap.model.OpenStreetMapLocation;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Handles the HTTP Search Response for the {@link NominatimClient}
 * <p>
 * Deserializes the JSON response into a {@link List} of {@link OpenStreetMapLocation}
 *
 * @author Bruno Jesus
 * @version 1.0
 * @see NominatimClient
 * @since 2023-05-11
 */
public class NominatimResponseHandler implements HttpClientResponseHandler<List<OpenStreetMapLocation>> {

    private final ObjectMapper objectMapper;

    public NominatimResponseHandler() {
        this.objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public NominatimResponseHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public List<OpenStreetMapLocation> handleResponse(ClassicHttpResponse response) throws IOException {
        if (response.getCode() < 200 || response.getCode() > 299) {
            return null;
        }

        try (InputStream body = response.getEntity().getContent()) {
            return this.objectMapper.readValue(body, new TypeReference<List<OpenStreetMapLocation>>() {
            });
        }
    }

}