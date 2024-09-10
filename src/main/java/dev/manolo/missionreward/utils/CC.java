package dev.manolo.missionreward.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class CC {

    public static String translate(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static void log(String msg) {
        Bukkit.getConsoleSender().sendMessage(translate(msg));
    }

}
