package me.waiaf.skytizencore;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemManager {

    public static HashMap<Integer, ItemStack> itemIDs = new HashMap<>();
    public static ItemStack testItem;
    public static ItemStack menuItem;

    public static void init(){

        createTestItem();
        createMenuItem();

    }

    private static void createTestItem(){

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.RED + "đây là item test");
        testItem = itemBuilder(Material.DIRT, ChatColor.WHITE + "lol", lore, 0, 0);

    }

    private static void createMenuItem(){

        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GRAY + "Chuột phải để mở menu!");
        menuItem = itemBuilder(Material.NETHER_STAR, ChatColor.WHITE + "Menu", lore, 1, 1);

    }

    private static ItemStack itemBuilder(Material material, String itemName, List<String> lore, Integer modelData, Integer ID){

        ItemStack itemStack = new ItemStack(material);
        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setDisplayName(itemName);
        meta.setLore(lore);
        meta.setCustomModelData(modelData);
        itemStack.setItemMeta(meta);
        itemIDs.put(ID, itemStack);

        return itemStack;
    }


}
