package pt.brunojesus.locationsearch.openstreetmap.http;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import pt.brunojesus.locationsearch.openstreetmap.model.OpenStreetMapLocation;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Client for the Nominatim API
 * Uses <a href="https://nominatim.org/release-docs/develop/api/Overview/">Nominatim</a> to fetch the locations.
 * <p>
 * We rely on Apache HttpClient to do the HTTP requests to the Nominatim WebAPI.
 *
 * @author Bruno Jesus
 * @version 1.0
 * @see NominatimResponseHandler
 * @see OpenStreetMapLocation
 * @since 2023-05-11
 */
public class NominatimClient {

    protected final static String searchUrlFormat = "https://nominatim.openstreetmap.org/search.php?q=%s&format=jsonv2";

    protected final NominatimResponseHandler responseHandler;

    public NominatimClient() {
        this.responseHandler = new NominatimResponseHandler();
    }

    public NominatimClient(NominatimResponseHandler responseHandler) {
        this.responseHandler = responseHandler;
    }

    /**
     * Does the search HTTP request to Nominatim's WebAPI
     *
     * @param searchExpression the expression to search for (Big Ben, London)
     * @return a {@link List} of {@link OpenStreetMapLocation} containing a deserialized response
     * @throws IOException If the HTTP Request fails
     */
    public List<OpenStreetMapLocation> search(String searchExpression) throws IOException {
        final String url = String.format(
                searchUrlFormat,
                URLEncoder.encode(searchExpression, StandardCharsets.UTF_8)
        );

        final HttpGet request = new HttpGet(url);
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-Type", "application/json");

        try (CloseableHttpClient client = HttpClients.createDefault()) {
            return client.execute(request, responseHandler);
        }
    }
}
