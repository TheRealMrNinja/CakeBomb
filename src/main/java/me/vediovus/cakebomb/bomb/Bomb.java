package me.vediovus.cakebomb.bomb;

import me.vediovus.cakebomb.CakeBomb;
import org.bukkit.Location;

public class Bomb {

    String whoPlaced;
    Location location;

    public Bomb(String whoPlaced, Location location) {
        this.whoPlaced = whoPlaced;
        this.location = location;
    }

    public String getWhoPlaced() {
        return whoPlaced;
    }

    public void addToList() {
        CakeBomb.bombLocations.put(location,whoPlaced);
    }

    public void removeFromList() {
        CakeBomb.bombLocations.remove(location);
    }

}
