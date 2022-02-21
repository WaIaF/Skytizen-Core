package me.waiaf.skytizencore.commands

import org.bukkit.ChatColor
import org.bukkit.GameMode
import org.bukkit.entity.Player

@CommandInfo(name = "spectator", permission = "rank.builder", requiresPlayer = true)
class SpectatorCommand : PluginCommand() {
    override fun execute(player: Player, args: Array<String>?) {
        player.gameMode = GameMode.ADVENTURE
        player.sendMessage(ChatColor.GREEN.toString() + "Đã chuyển sang chế độ kháng giả")
    }
}