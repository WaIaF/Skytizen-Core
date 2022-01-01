package me.waiaf.skytizencore.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public abstract class PluginCommand implements CommandExecutor {

    private final CommandInfo commandInfo;

    public PluginCommand() {

        commandInfo = this.getClass().getDeclaredAnnotation(CommandInfo.class);
        Objects.requireNonNull(commandInfo, "Epic gamer code you got there idot");

    }

    public CommandInfo getCommandInfo() {

        return commandInfo;

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!commandInfo.permission().isEmpty()){

            if (!sender.hasPermission(commandInfo.permission())){

                sender.sendMessage(ChatColor.RED + "Bạn không có quyền sử dụng lệnh này!");
                return true;

            }

        }

        if (commandInfo.requiresPlayer()) {

            if (!(sender instanceof Player)) {

                sender.sendMessage(ChatColor.RED + "Chỉ người chơi mới có thể sử dụng được lệnh này!");
                return true;

            }

            execute((Player) sender, args);
            return true;

        }

        execute(sender, args);
        return true;

    }

    public void execute(Player player, String[] args){}
    public void execute(CommandSender sender, String[] args){}

}
