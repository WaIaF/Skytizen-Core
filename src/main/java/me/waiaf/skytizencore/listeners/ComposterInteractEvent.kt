package me.waiaf.skytizencore.listeners

import org.bukkit.Material
import org.bukkit.block.data.Levelled
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack

class ComposterInteractEvent : Listener {
    @EventHandler
    fun playerInteractComposterEvent(event: PlayerInteractEvent) {
        val block = event.clickedBlock ?: return
        val material = block.type
        if (material != Material.COMPOSTER) return
        val composter = block.blockData as Levelled
        val player = event.player
        if (composter.level != composter.maximumLevel - 1) {
            if (!player.inventory.itemInMainHand.type.toString().contains("SAPLING")) return
            if (player.inventory.itemInMainHand.amount == 1) {
                player.inventory.itemInMainHand.amount = 0
            } else {
                player.inventory.itemInMainHand.amount = player.inventory.itemInMainHand.amount - 1
            }
            event.isCancelled = true
            composter.level = composter.level + 1
            block.blockData = composter
        } else if (composter.level == composter.maximumLevel) {
            if (player.isSneaking) return
            event.isCancelled = true
            block.world.dropItemNaturally(block.location, ItemStack(Material.DIRT, 1))
            composter.level = 0
            block.blockData = composter
        }
    }
}