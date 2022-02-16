package me.waiaf.skytizencore;

import me.waiaf.skytizencore.commands.PluginCommand;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable(){

        ItemManager.init();

        String packageName = this.getClass().getPackage().getName();
        
        for (Class<?> clazz : new Reflections(packageName + ".listeners").getSubTypesOf(Listener.class)){

            try {

                Listener listener = (Listener) clazz.getDeclaredConstructor().newInstance();
                this.getServer().getPluginManager().registerEvents(listener, this);

            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e){

                e.printStackTrace();

            }

        }

        for (Class<? extends PluginCommand> clazz : new Reflections(packageName + ".commands").getSubTypesOf(PluginCommand.class)){

            try {

                PluginCommand pluginCommand = clazz.getDeclaredConstructor().newInstance();
                Objects.requireNonNull(this.getCommand(pluginCommand.getCommandInfo().name())).setExecutor(pluginCommand);

            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e){

                e.printStackTrace();

            }

        }

    }
}
