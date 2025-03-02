package dev.dtgaeh.workfromhere.spaces.model;

import lombok.Getter;

@Getter
public enum SpaceTypeResource {
    CAFE(1, "Cafe"),;

    private final int id;
    private final String name;

    SpaceTypeResource(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
