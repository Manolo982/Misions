package dev.manolo.missionreward.challenge.chs;

import dev.manolo.missionreward.MissionReward;
import dev.manolo.missionreward.model.MissionManager;
import dev.manolo.missionreward.utils.CC;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class DirtChallenge implements Listener {

    private MissionReward plugin;
    private int blockBreaks;
    private int stacks;
    private int stage;

    public DirtChallenge(MissionReward plugin) {
        this.plugin = plugin;
        this.blockBreaks = 0;
        this.stacks = 0;
        this.stage = 1;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onBreakBlock(BlockBreakEvent event) {
        Player player = event.getPlayer();

        if (player.getGameMode() != GameMode.SURVIVAL) {
            return;
        }

        if (this.plugin.getMissionManager().contains(player.getUniqueId())) {
            if (event.getBlock().getType().equals(Material.DIRT) || event.getBlock().getType().equals(Material.GRASS)) {
                if (stage == 1) {
                    this.blockBreaks++;
                    if (this.blockBreaks >= 64) {
                        this.stacks++;
                        this.blockBreaks = 0;
                        if (this.stacks == 1) {
                            player.sendMessage(CC.translate("&6DirtMission: &7you has broken &e1 STACK &7of dirt blocks."));
                        } else if (this.stacks == 2) {
                            MissionManager.getInstance().remove(player.getUniqueId());
                            player.sendMessage(CC.translate("&aCongrulations!!! you has passed challenge"));
                            this.stage++;
                            this.stacks = 0;
                        }

                        //
                        //  RECOMPENSE
                        //
                    }
                } else if (stage == 2) {
                    this.blockBreaks++;
                    if (this.blockBreaks >= 64) {
                        this.stacks++;
                        this.blockBreaks = 0;

                        switch (this.stacks) {
                            case 1:
                                player.sendMessage(CC.translate("&6DirtMission: &7you has broken &e1 STACK &7of dirt blocks."));
                                break;
                            case 2:
                                player.sendMessage(CC.translate("&6DirtMission: &7you has broken &e2 STACK &7of dirt blocks."));
                                break;
                            case 3:
                                MissionManager.getInstance().remove(player.getUniqueId());
                                player.sendMessage(CC.translate("&6DirtMission: &7you has broken &e3 STACK &7of dirt blocks."));
                                player.sendMessage(CC.translate("&aCongrulations!!! you has passed challenge stage (&eII&7)."));
                                break;
                        }

                        //
                        //  RECOMPENSE
                        //
                    }
                }
            } else {
                player.sendMessage(CC.translate("&cthat block not is type dirt."));
            }
        } else {
            return;
        }
    }

}
