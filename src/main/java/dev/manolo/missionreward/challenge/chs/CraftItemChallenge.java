package dev.manolo.missionreward.challenge.chs;

import dev.manolo.missionreward.MissionReward;
import dev.manolo.missionreward.model.MissionManager;
import dev.manolo.missionreward.utils.CC;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

public class  CraftItemChallenge implements Listener {

    private MissionReward plugin;

    public CraftItemChallenge(MissionReward plugin){
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onKillZombie(CraftItemEvent event) {
        Player player = (Player) event.getWhoClicked();

        if(this.plugin.getMissionManager().containsValue("zombiechall")){
            switch (event.getRecipe().getResult().getType()){
                case DIAMOND_SWORD:
                    player.sendMessage(CC.translate("&eHas creado una espada, has pasado la mision de craftear!"));

                    MissionManager.getInstance().remove(player.getUniqueId());
                    break;
            }
        }
    }

}
