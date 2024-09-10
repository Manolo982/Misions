package dev.manolo.missionreward.menu;

import dev.manolo.missionreward.MissionReward;
import dev.manolo.missionreward.model.Mission;
import dev.manolo.missionreward.model.MissionManager;
import dev.manolo.missionreward.utils.CC;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class MissionMenu implements Listener {
    
    @Getter
    private Inventory inventory;
    private Mission mission;
    
    private MissionReward plugin;
    
    public MissionMenu(MissionReward plugin) {
        this.inventory = Bukkit.createInventory(null, 27, CC.translate("&6Missions Menu"));
        this.plugin = plugin;
        this.plugin.getServer()
                .getPluginManager()
                .registerEvents(this, this.plugin);
    }
    
    public void mainInv(Player player) {
        this.inventory.setItem(0, this.dirtMission());
        this.inventory.setItem(1, this.missio2());
        this.inventory.setItem(26, this.back());
        
        player.openInventory(this.inventory);
    }
    
    private ItemStack dirtMission() {
        ItemStack stack = new ItemStack(Material.DIAMOND, 1);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(CC.translate("&6DirtMission"));
        meta.setLore(Arrays.asList(CC.translate("&7Left-Click for start mission"),
                CC.translate("&bYou have to mine dirt blocks"),
                CC.translate("&bto complete this mission.")));
        stack.setItemMeta(meta);
        
        return stack;
    }
    
    private ItemStack missio2() {
        ItemStack stack = new ItemStack(Material.GOLD_INGOT, 1);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(CC.translate("&6Mission #2"));
        meta.setLore(Arrays.asList(CC.translate("&7Right-Click for start mission"),
                CC.translate("&7Left-Click for start mission"),
                CC.translate("&eYou had rewards for complete this mission")));
        stack.setItemMeta(meta);
        
        return stack;
    }
    
    private ItemStack back() {
        ItemStack stack = new ItemStack(Material.REDSTONE_BLOCK, 1);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(CC.translate("&cBack"));
        meta.setLore(Arrays.asList(CC.translate("&7Right-Click for exit menu.")));
        stack.setItemMeta(meta);
        
        return stack;
    }

    /*
    ===========
    ! LISTENERS
    ===========

     */
    @EventHandler
    public void clickInventiry(InventoryClickEvent event) {
        if (event.getClickedInventory() == null || event.getCurrentItem() == null) {
            return;
        }
        
        if (event.getClickedInventory().getName().equalsIgnoreCase(CC.translate("&6Missions Menu"))) {
            Player player = (Player) event.getWhoClicked();
            event.setCancelled(true);
            
            ItemStack item = event.getCurrentItem();
            if (!this.plugin.getMissionManager().contains(player.getUniqueId())) {
                if (item.hasItemMeta()) {
                    if (item.getItemMeta().getDisplayName().equalsIgnoreCase(CC.translate("&6DirtMission"))) {
                        mission = new Mission("dirtm");
                        mission.setDescription(CC.translate("&bYou have to mine dirt blocks \n" + "&bto complete this mission."));
                        
                        this.plugin.getMissionManager().add(player.getUniqueId(), mission.getName());
                        player.sendMessage(CC.translate("&7You have started the dirt mission."));
                        player.sendMessage(mission.getDescription());
                        player.closeInventory();
                    } else if (item.getItemMeta().getDisplayName().equalsIgnoreCase(CC.translate("&6Mission #2"))) {
                        
                    } else if (item.getItemMeta().getDisplayName().equalsIgnoreCase(CC.translate("&cBack"))) {
                        player.closeInventory();
                    }
                }
            } else {
                player.sendMessage(CC.translate("&cyou're in mision!."));
            }
            
        }
    }
}
