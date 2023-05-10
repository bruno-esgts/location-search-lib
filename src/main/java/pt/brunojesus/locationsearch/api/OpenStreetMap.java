package pt.brunojesus.locationsearch.api;

import pt.brunojesus.locationsearch.exception.LocationSearchException;
import pt.brunojesus.locationsearch.openstreetmap.http.NominatimClient;
import pt.brunojesus.locationsearch.openstreetmap.model.OpenStreetMapLocation;

import java.io.IOException;
import java.util.List;

public class OpenStreetMap {

    protected final NominatimClient client;

    public OpenStreetMap() {
        this.client = new NominatimClient();
    }

    public OpenStreetMap(NominatimClient client) {
        this.client = client;
    }

    public List<OpenStreetMapLocation> search(String searchExpression) throws LocationSearchException {
        try {
            return this.client.search(searchExpression);
        } catch (IOException e) {
            throw new LocationSearchException("Error while searching for location", e);
        }
    }
}
