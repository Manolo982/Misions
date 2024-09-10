package dev.manolo.missionreward.model;

import dev.manolo.missionreward.menu.MissionMenu;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

import java.util.UUID;

@Getter
public class Mission {

    @Setter
    private String name;
    @Setter
    private String description;

    public Mission(String name) {
        this.name = name;
    }

}
