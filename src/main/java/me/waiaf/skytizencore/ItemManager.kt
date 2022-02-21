package me.waiaf.skytizencore

import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

object ItemManager {
    var itemIDs = HashMap<Int, ItemStack>()
    var testItem: ItemStack? = null
    var menuItem: ItemStack? = null
    fun init() {
        createTestItem()
        createMenuItem()
    }

    private fun createTestItem() {
        val lore: MutableList<String> = ArrayList()
        lore.add(ChatColor.RED.toString() + "đây là item test")
        testItem = itemBuilder(Material.DIRT, ChatColor.WHITE.toString() + "lol", lore, 0, 0)
    }

    private fun createMenuItem() {
        val lore: MutableList<String> = ArrayList()
        lore.add("")
        lore.add(ChatColor.GRAY.toString() + "Chuột phải để mở menu!")
        menuItem = itemBuilder(Material.NETHER_STAR, ChatColor.WHITE.toString() + "Menu", lore, 1, 1)
    }

    private fun itemBuilder(
        material: Material,
        itemName: String,
        lore: List<String>,
        modelData: Int,
        ID: Int
    ): ItemStack {
        val itemStack = ItemStack(material)
        val meta = itemStack.itemMeta!!
        meta.setDisplayName(itemName)
        meta.lore = lore
        meta.setCustomModelData(modelData)
        itemStack.itemMeta = meta
        itemIDs[ID] = itemStack
        return itemStack
    }
}