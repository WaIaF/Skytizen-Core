package me.waiaf.skytizencore;

import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Profile {

    public ArrayList<Player> players = new ArrayList<>();
    public String profileName;
    public World world;

    public Profile(Player player, World world, String profileName){

        this.players.add(player);
        this.world = world;
        this.profileName = profileName;

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

}
