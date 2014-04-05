package me.vediovus.cakebomb.listener;

import me.vediovus.cakebomb.CakeBomb;
import me.vediovus.cakebomb.bomb.Bomb;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if(event.getClickedBlock().getType() == Material.CAKE_BLOCK) {
                Location location = event.getClickedBlock().getLocation();
                if(CakeBomb.bombLocations.containsKey(location)) {
                    Bomb bomb = new Bomb(CakeBomb.bombLocations.get(location),location);
                    if(p.getName().equalsIgnoreCase(bomb.getWhoPlaced())) {
                        location.getWorld().createExplosion(location.getX(),location.getY(),location.getZ(),2.0F,false,false);
                        event.setCancelled(true);
                        event.getClickedBlock().setType(Material.AIR);
                        p.sendMessage(ChatColor.RED + "This Cake is rigged! " + ChatColor.GRAY + CakeBomb.bombLocations.get(location) + ChatColor.RED + " got you!");
                        p.playSound(p.getLocation(), Sound.NOTE_SNARE_DRUM,5.0F,4.0F);
                        bomb.removeFromList();
                    }
                }
                else {
                    if(p.hasPermission("cakebomb.place")) {
                        if(p.getItemInHand().getType() == Material.SULPHUR && p.getItemInHand().getAmount() >= 5) {
                            Bomb bomb = new Bomb(p.getName(),location);
                            p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 5);
                            p.sendMessage(ChatColor.GREEN + "Your cake has been planted.");
                            bomb.addToList();
                            p.updateInventory();
                        }
                    }
                }
            }
        }
    }
}
