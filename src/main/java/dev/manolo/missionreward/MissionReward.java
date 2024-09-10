package dev.manolo.missionreward;

import dev.manolo.missionreward.challenge.Challenge;
import dev.manolo.missionreward.commands.MissionCommand;
import dev.manolo.missionreward.menu.MissionMenu;
import dev.manolo.missionreward.model.Mission;
import dev.manolo.missionreward.model.MissionManager;
import dev.manolo.missionreward.utils.FileUtils;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

@Getter
public final class MissionReward extends JavaPlugin {

    @Getter
    private static MissionReward instance;

    private MissionManager missionManager;
    private Challenge challenge;

    @Getter
    private MissionMenu menu;

    // private FileUtils config;

    @Override
    public void onEnable() {
        instance = this;

        //      ! Files !       //
        // this.loadConfigs();

        this.missionManager = new MissionManager();
        this.menu = new MissionMenu(this);
        this.challenge = new Challenge(this);

     //        ? Commands  ?     //
        this.loadCmds();


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void loadCmds() {
        getCommand("mision").setExecutor(new MissionCommand(this));
    }

//    private void loadConfigs() {
//        config = new FileUtils(this,"config.yml");
//    }


}
