package me.waiaf.skytizencore.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

@CommandInfo(name = "spectator", permission = "rank.builder", requiresPlayer = true)
public class SpectatorCommand extends PluginCommand{

    @Override
    public void execute(Player player, String[] args) {

        player.setGameMode(GameMode.ADVENTURE);
        player.sendMessage(ChatColor.GREEN + "Đã chuyển sang chế độ kháng giả");

    }

}
