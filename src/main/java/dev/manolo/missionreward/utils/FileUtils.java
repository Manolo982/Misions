package dev.manolo.missionreward.utils;

import dev.manolo.missionreward.MissionReward;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

@Getter
public class FileUtils {

    private File file;
    private MissionReward plugin;
    @Setter
    private FileConfiguration config;

    public FileUtils(MissionReward plugin, String fileName) {
        this.plugin = plugin;
        this.file = new File(plugin.getDataFolder(), fileName);

        if (!this.file.exists()) {
            this.file.getParentFile().mkdirs();

            if (plugin.getResource(fileName) == null) {
                try {
                    this.file.createNewFile();
                } catch (IOException e) {
                    plugin.getLogger().severe("Failed to create new file " + fileName);
                }
            } else {
                plugin.saveResource(fileName, false);
            }
        }

        this.config = YamlConfiguration.loadConfiguration(this.file);
    }

    public void save() {
        try {
            this.config.save(this.file);
        } catch (IOException e) {
            Bukkit.getLogger().severe("Could not save config file " + this.file.toString());
            e.printStackTrace();
        }
    }

}