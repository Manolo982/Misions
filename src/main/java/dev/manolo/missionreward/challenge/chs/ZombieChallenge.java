package dev.manolo.missionreward.challenge.chs;

import dev.manolo.missionreward.MissionReward;
import dev.manolo.missionreward.utils.CC;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class ZombieChallenge implements Listener {

    private int kills;
    private MissionReward plugin;

    public ZombieChallenge(MissionReward plugin){
        this.kills = 0;
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }


    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onKillZombie(EntityDamageByEntityEvent event) {
        Player damager = (Player) event.getDamager();
        Zombie entity = (Zombie) event.getEntity();

            if (this.plugin.getMissionManager().containsValue("zombiechall")) {
                if(event.getEntity().getType() != EntityType.ZOMBIE){
                    event.setCancelled(true);
                    damager.sendMessage("&cEso no es un zombie.");
                    return;
                }
                if(entity.getHealth()  > damager.getHealth()){
                    damager.sendMessage("has matado un zombie");
                }
            }
        }

}
