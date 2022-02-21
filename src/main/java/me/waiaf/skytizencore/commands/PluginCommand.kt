package me.waiaf.skytizencore.commands

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import java.util.*

abstract class PluginCommand : CommandExecutor {
    val commandInfo: CommandInfo = this.javaClass.getDeclaredAnnotation(CommandInfo::class.java)
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (commandInfo.permission.isNotEmpty()) {
            if (!sender.hasPermission(commandInfo.permission)) {
                sender.sendMessage(ChatColor.RED.toString() + "Bạn không có quyền sử dụng lệnh này!")
                return true
            }
        }
        if (commandInfo.requiresPlayer) {
            if (sender !is Player) {
                sender.sendMessage(ChatColor.RED.toString() + "Chỉ người chơi mới có thể sử dụng được lệnh này!")
                return true
            }
            execute(sender, args)
            return true
        }
        execute(sender, args)
        return true
    }

    open fun execute(player: Player, args: Array<String>?) { /*execute as player*/
    }

    open fun execute(sender: CommandSender?, args: Array<String>?) { /*execute as console ect.*/
    }

    init {
        Objects.requireNonNull(commandInfo, "Epic gamer code you got there idot")
    }
}