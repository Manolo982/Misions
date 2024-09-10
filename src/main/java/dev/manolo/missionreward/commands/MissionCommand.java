package dev.manolo.missionreward.commands;

import dev.manolo.missionreward.MissionReward;
import dev.manolo.missionreward.menu.MissionMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MissionCommand implements CommandExecutor {

    private MissionReward plugin;

    public MissionCommand(MissionReward plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            return true;
        }

        Player player = (Player) commandSender;

        this.plugin.getMenu().mainInv(player);

        return false;
    }
}
