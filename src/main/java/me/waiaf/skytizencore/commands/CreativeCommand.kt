package me.waiaf.skytizencore.commands

import org.bukkit.ChatColor
import org.bukkit.GameMode
import org.bukkit.entity.Player

@CommandInfo(name = "creative", permission = "rank.builder", requiresPlayer = true)
class CreativeCommand : PluginCommand() {
    override fun execute(player: Player, args: Array<String>?) {
        player.gameMode = GameMode.CREATIVE
        player.sendMessage(ChatColor.GREEN.toString() + "Đã chuyển sang chế độ sáng tạo")
    }
}