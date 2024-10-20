package dh.workfromhere.backend.spaces.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpaceResource {
    private Integer id;
    private String name;
    private String description;
    private SpaceTypeResource type;
    private Boolean wifiAvailable;
    private String wifiPassword;
    private Integer wifiSpeed;
}
