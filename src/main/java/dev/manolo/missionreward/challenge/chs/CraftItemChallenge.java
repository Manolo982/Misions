package dev.manolo.missionreward.challenge.chs;

import dev.manolo.missionreward.MissionReward;
import dev.manolo.missionreward.model.MissionManager;
import dev.manolo.missionreward.utils.CC;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

public class  CraftItemChallenge implements Listener {

    private MissionReward plugin;
    private boolean firstItem;

    public CraftItemChallenge(MissionReward plugin){
        this.plugin = plugin;
        this.firstItem = false;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onKillZombie(CraftItemEvent event) {
        Player player = (Player) event.getWhoClicked();

        if(this.plugin.getMissionManager().containsValue("zombiechall")){
            if(player.getGameMode() != GameMode.SURVIVAL){
                event.setCancelled(true);
                player.sendMessage(CC.translate("&cTienes que estar en modo supervivencia."));
                return;
            }
            switch (event.getRecipe().getResult().getType()){
                case ENCHANTMENT_TABLE:
                    if(this.firstItem){
                        player.sendMessage(CC.translate("&cYa haz hecho la primera fase de la mision!"));
                        break;
                    }
                    player.sendMessage(CC.translate("&eHaz pasado la primera face de la mision."));
                    player.sendMessage(CC.translate("&aAhora tienes que crear una espada de diamante"));
                    this.firstItem=true;
                    break;
                case DIAMOND_SWORD:
                    if(!this.firstItem){
                        player.sendMessage(CC.translate("&cTienes que crear primero una mesa de encantamientos"));
                        break;
                    }
                    player.sendMessage(CC.translate("&eHas creado una espada, has pasado la mision de craftear!"));
                    player.sendMessage(CC.translate("&aAhora tienes que crear una espada de diamante"));
                    MissionManager.getInstance().remove(player.getUniqueId());
                    break;

            }
        }
    }

}
