package me.waiaf.skytizencore.commands

import org.bukkit.ChatColor
import org.bukkit.GameMode
import org.bukkit.entity.Player

@CommandInfo(name = "survival", permission = "rank.builder", requiresPlayer = true)
class SurvivalCommand : PluginCommand() {
    override fun execute(player: Player, args: Array<String>?) {
        player.gameMode = GameMode.SURVIVAL
        player.sendMessage(ChatColor.GREEN.toString() + "Đã chuyển sang chế độ sinh tồn")
    }
}