package pt.brunojesus.locationsearch.openstreetmap.model;

import lombok.Data;

import java.util.List;

@Data
public class OpenStreetMapSearchResult {

    private List<OpenStreetMapLocation> locations;
}
