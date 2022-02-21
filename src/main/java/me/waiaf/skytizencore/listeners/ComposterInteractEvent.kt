package me.waiaf.skytizencore.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Levelled;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ComposterInteractEvent implements Listener {

    @EventHandler
    public void PlayerInteractComposterEvent(PlayerInteractEvent event){

        Block block = event.getClickedBlock();
        if (block == null) return;
        Material material = block.getType();
        if (!material.equals(Material.COMPOSTER)) return;
        Levelled composter = (Levelled) block.getBlockData();
        Player player = event.getPlayer();

        if (!(composter.getLevel() == (composter.getMaximumLevel() - 1))){

            if (!player.getInventory().getItemInMainHand().getType().toString().contains("SAPLING")) return;

            if (player.getInventory().getItemInMainHand().getAmount() == 1){

                player.getInventory().getItemInMainHand().setAmount(0);

            } else {

                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);

            }

            event.setCancelled(true);
            composter.setLevel(composter.getLevel() + 1);
            block.setBlockData(composter);

        } else if (composter.getLevel() == composter.getMaximumLevel()){

            if (player.isSneaking()) return;
            event.setCancelled(true);
            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.DIRT, 1));
            composter.setLevel(0);
            block.setBlockData(composter);

        }

    }
}
