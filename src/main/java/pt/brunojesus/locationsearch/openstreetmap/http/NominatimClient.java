package pt.brunojesus.locationsearch.openstreetmap.http;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import pt.brunojesus.locationsearch.openstreetmap.model.OpenStreetMapLocation;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class NominatimClient {

    protected final static String searchUrlFormat = "https://nominatim.openstreetmap.org/search.php?q=%s&format=jsonv2";

    protected final NominatimResponseHandler responseHandler;

    public NominatimClient() {
        this.responseHandler = new NominatimResponseHandler();
    }

    public NominatimClient(NominatimResponseHandler responseHandler) {
        this.responseHandler = responseHandler;
    }

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
