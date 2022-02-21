package me.waiaf.skytizencore.listeners

import me.waiaf.skytizencore.ItemManager
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class PlayerFirstJoin : Listener {
    @EventHandler
    fun playerFirstJoinListener(event: PlayerJoinEvent) {
        val player = event.player
        if (player.hasPlayedBefore()) return
        player.inventory.setItem(8, ItemManager.menuItem)
    }
}