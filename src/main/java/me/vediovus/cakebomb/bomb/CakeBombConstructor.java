package me.vediovus.cakebomb.bomb;

import org.bukkit.Location;

import java.util.HashMap;

public class CakeBombConstructor {

    public HashMap<Location,String> activeBombs = new HashMap<Location, String>();

    private String playerWhoPlaced;
    private Location location;

    public CakeBombConstructor(String playerWhoPlaced, Location location) {
        this.playerWhoPlaced = playerWhoPlaced;
        this.location = location;
    }

    public void addToList() {
        activeBombs.put(location,playerWhoPlaced);
    }

    public String getPlayerWhoPlaced() {
        return playerWhoPlaced;
    }

    public boolean isBomb() {
        if(activeBombs.containsKey(location)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void removeFromList() {
        activeBombs.remove(location);
    }

}
