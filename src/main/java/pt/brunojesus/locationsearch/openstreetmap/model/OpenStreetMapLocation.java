package pt.brunojesus.locationsearch.openstreetmap.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class OpenStreetMapLocation {

    @JsonProperty("place_id")
    private Long placeId;

    private String licence;

    @JsonProperty("osm_type")
    private String osmType;

    @JsonProperty("osm_id")
    private Long osmId;

    @JsonProperty("boundingbox")
    private List<String> boundingBox;

    @JsonProperty("lat")
    private String latitute;

    @JsonProperty("lon")
    private String longitude;

    @JsonProperty("display_name")
    private String displayName;

    @JsonProperty("place_rank")
    private Integer placeRank;

    @JsonProperty("category")
    private String category;

    @JsonProperty("type")
    private String type;

    private Double importance;

    private String icon;
}
