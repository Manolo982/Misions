package dev.manolo.missionreward.challenge;

import dev.manolo.missionreward.MissionReward;
import dev.manolo.missionreward.challenge.chs.DirtChallenge;
import dev.manolo.missionreward.challenge.chs.ZombieChallenge;

public class Challenge {

    private MissionReward plugin;

    private DirtChallenge dirtChallenge;
    private ZombieChallenge zombieChallenge;

    public Challenge(MissionReward plugin) {
        this.plugin = plugin;
        this.dirtChallenge = new DirtChallenge(plugin);
        this.zombieChallenge = new ZombieChallenge(plugin);
    }

}
