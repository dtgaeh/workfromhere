package dev.dtgaeh.workfromhere.spaces.model;

import lombok.Getter;

@Getter
public enum SpaceTypeResource {
    CAFE(1, "Cafe"),
    BAR(2, "Bar"),
    HOT_DESK(3, "Hot Desk"),;

    private final int id;
    private final String name;

    SpaceTypeResource(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
