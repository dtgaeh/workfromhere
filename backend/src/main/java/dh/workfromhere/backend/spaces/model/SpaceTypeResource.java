package dh.workfromhere.backend.spaces.model;

import lombok.Data;
import lombok.Getter;

@Getter
public enum SpaceTypeResource {

    CAFE(1, "Cafe"),
    LIBRARY(2, "Library"),
    HOT_DESK(3, "Hot Desk");

    SpaceTypeResource(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    private final Integer id;
    private final String name;
}
