package me.waiaf.skytizencore

import me.waiaf.skytizencore.commands.PluginCommand
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin
import org.reflections.Reflections
import java.lang.reflect.InvocationTargetException
import java.util.*

class Main : JavaPlugin() {
    override fun onEnable() {
        ItemManager.init()
        val packageName = this.javaClass.getPackage().name
        for (clazz in Reflections("$packageName.listeners").getSubTypesOf(
            Listener::class.java
        )) {
            try {
                val listener = clazz.getDeclaredConstructor().newInstance() as Listener
                server.pluginManager.registerEvents(listener, this)
            } catch (e: InstantiationException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            } catch (e: InvocationTargetException) {
                e.printStackTrace()
            } catch (e: NoSuchMethodException) {
                e.printStackTrace()
            }
        }
        for (clazz in Reflections("$packageName.commands").getSubTypesOf(
            PluginCommand::class.java
        )) {
            try {
                val pluginCommand = clazz.getDeclaredConstructor().newInstance()
                Objects.requireNonNull(getCommand(pluginCommand.commandInfo.name))?.setExecutor(pluginCommand)
            } catch (e: InstantiationException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            } catch (e: InvocationTargetException) {
                e.printStackTrace()
            } catch (e: NoSuchMethodException) {
                e.printStackTrace()
            }
        }
    }
}