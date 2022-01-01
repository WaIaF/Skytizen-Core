package me.waiaf.skytizencore.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

@CommandInfo(name = "survival", permission = "rank.builder", requiresPlayer = true)
public class SurvivalCommand extends PluginCommand {

    @Override
    public void execute(Player player, String[] args) {

        player.setGameMode(GameMode.SURVIVAL);
        player.sendMessage(ChatColor.GREEN + "Đã chuyển sang chế độ sinh tồn");

    }
}
