package dev.manolo.missionreward.model;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

import java.util.UUID;

@Getter
public class MissionManager {
    
    private Map<UUID, String> misions = new HashMap<>();

    private Mission mission;
    @Getter
    private static MissionManager instance;

    public MissionManager() {
        instance = this;
    }

    public void add(UUID uuid, String name) {
        this.getMisions().put(uuid, name);

    }

    public void remove(UUID uuid) {
        this.getMisions().remove(uuid);
    }


    public boolean contains(UUID uuid) {
        if(uuid != null){
           return this.misions.containsKey(uuid);
        }
        return false;
    }

    public boolean containsValue(String name) {
        return this.getMisions().containsValue(name);
    }

}
