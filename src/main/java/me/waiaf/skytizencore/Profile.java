package me.waiaf.skytizencore;

import me.waiaf.skytizencore.enums.ProfileType;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.HashMap;

public class Profile {

    public ArrayList<Player> players = new ArrayList<>();
    public String profileName;
    public World world;
    public HashMap<Player, Inventory> playerInventory = new HashMap<>();
    public ProfileType profileType;

    public Profile(Player player, World world, String profileName, ProfileType profileType){

        this.players.add(player);
        this.world = world;
        this.profileName = profileName;
        this.profileType = profileType;

    }

    public void addPlayer(Player player){
        this.players.add(player);
        ArrayList<Profile> playerProfile = Main.playerProfiles.get(player);
        playerProfile.add(this);
        Main.playerProfiles.put(player, playerProfile);
    }

    public void removePlayer(Player player){
        this.players.remove(player);
        ArrayList<Profile> playerProfile = Main.playerProfiles.get(player);
        playerProfile.remove(this);
        Main.playerProfiles.put(player, playerProfile);
    }

    public World getWorld(){
        return this.world;
    }

    public ArrayList<Player> getPlayers(){
        return this.players;
    }

    public String getProfileName(){
        return this.profileName;
    }

    public ProfileType getProfileType(){
        return this.profileType;
    }

}
