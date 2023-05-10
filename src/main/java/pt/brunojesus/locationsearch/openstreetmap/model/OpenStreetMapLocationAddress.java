package pt.brunojesus.locationsearch.openstreetmap.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OpenStreetMapLocationAddress {

    private String city;

    @JsonProperty("state_district")
    private String stateDistrict;

    @JsonProperty("state")
    private String state;

    @JsonProperty("ISO3166-2-lvl4")
    private String iso3166;

    @JsonProperty("postcode")
    private String postCode;

    private String country;

    @JsonProperty("countryCode")
    private String countryCode;
}
