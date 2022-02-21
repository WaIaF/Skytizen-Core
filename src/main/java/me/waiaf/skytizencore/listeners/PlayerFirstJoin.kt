package me.waiaf.skytizencore.listeners;

import me.waiaf.skytizencore.ItemManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerFirstJoin implements Listener {

    @EventHandler
    public void playerFirstJoinListener(PlayerJoinEvent event){

        Player player = event.getPlayer();

        if (player.hasPlayedBefore()) return;

        player.getInventory().setItem(8, ItemManager.menuItem);

    }
}
