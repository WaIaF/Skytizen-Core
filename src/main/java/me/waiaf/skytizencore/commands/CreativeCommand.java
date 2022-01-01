package me.waiaf.skytizencore.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

@CommandInfo(name = "creative", permission = "rank.builder", requiresPlayer = true)
public class CreativeCommand extends PluginCommand {

    @Override
    public void execute(Player player, String[] args) {

        player.setGameMode(GameMode.CREATIVE);
        player.sendMessage(ChatColor.GREEN + "Đã chuyển sang chế độ sáng tạo");

    }

}