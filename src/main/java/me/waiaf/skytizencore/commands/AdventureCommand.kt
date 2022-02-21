package me.waiaf.skytizencore.commands

import org.bukkit.ChatColor
import org.bukkit.GameMode
import org.bukkit.entity.Player

@CommandInfo(name = "adventure", permission = "rank.builder", requiresPlayer = true)
class AdventureCommand : PluginCommand() {
    override fun execute(player: Player, args: Array<String>?) {
        player.gameMode = GameMode.ADVENTURE
        player.sendMessage(ChatColor.GREEN.toString() + "Đã chuyển sang chế độ thám hiểm")
    }
}