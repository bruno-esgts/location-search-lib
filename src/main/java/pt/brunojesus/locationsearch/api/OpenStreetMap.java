package pt.brunojesus.locationsearch.api;

import pt.brunojesus.locationsearch.exception.LocationSearchException;
import pt.brunojesus.locationsearch.openstreetmap.http.NominatimClient;
import pt.brunojesus.locationsearch.openstreetmap.model.OpenStreetMapLocation;

import java.io.IOException;
import java.util.List;

/**
 * Searches for locations on OpenStreetMap
 *
 * @author Bruno Jesus
 * @version 1.0
 * @since 2023-05-11
 */
public class OpenStreetMap {

    protected final NominatimClient client;

    public OpenStreetMap() {
        this.client = new NominatimClient();
    }

    public OpenStreetMap(NominatimClient client) {
        this.client = client;
    }

    /**
     * Searches for a location on OpenStreetMap
     *
     * @param searchExpression the search query (i.e: Big Ben, London)
     * @return A list with the found locations
     * @throws LocationSearchException if the {@link NominatimClient} isn't able to fetch the locations
     */
    public List<OpenStreetMapLocation> search(String searchExpression) throws LocationSearchException {
        try {
            return this.client.search(searchExpression);
        } catch (IOException e) {
            throw new LocationSearchException("Error while searching for location", e);
        }
    }
}
