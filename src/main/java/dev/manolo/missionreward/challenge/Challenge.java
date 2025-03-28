package dev.manolo.missionreward.challenge;

import dev.manolo.missionreward.MissionReward;
import dev.manolo.missionreward.challenge.chs.CraftItemChallenge;
import dev.manolo.missionreward.challenge.chs.DirtChallenge;

public class Challenge {

    private MissionReward plugin;

    private DirtChallenge dirtChallenge;
    private CraftItemChallenge craftItemChallenge;

    public Challenge(MissionReward plugin) {
        this.plugin = plugin;
        this.dirtChallenge = new DirtChallenge(plugin);
        this.craftItemChallenge = new CraftItemChallenge(plugin);
    }

}
