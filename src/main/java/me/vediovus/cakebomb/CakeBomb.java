package me.vediovus.cakebomb;

import me.vediovus.cakebomb.listener.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class CakeBomb extends JavaPlugin {

    public static HashMap<Location,String> bombLocations = new HashMap<Location, String>();

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
    }

}
