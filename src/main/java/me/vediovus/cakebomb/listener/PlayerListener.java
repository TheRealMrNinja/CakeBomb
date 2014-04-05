package me.vediovus.cakebomb.listener;

import me.vediovus.cakebomb.bomb.CakeBombConstructor;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        if (event.getClickedBlock().getType().equals(Material.CAKE_BLOCK)) {
            CakeBombConstructor cake = new CakeBombConstructor(p.getName(), event.getClickedBlock().getLocation());
            if (cake.isBomb()) {
                p.getWorld().createExplosion(p.getLocation().getX(),p.getLocation().getY(),p.getLocation().getZ(),1.0F,false,false);
                p.playSound(p.getLocation(), Sound.NOTE_SNARE_DRUM,5.0F,4.0F);
                p.sendMessage(ChatColor.RED + "This Cake is rigged!");
            } else {
                if (p.hasPermission("cakebomb.create")) {
                    if (p.getItemInHand().getType().equals(Material.SULPHUR) && p.getItemInHand().getAmount() == 5) {
                        p.sendMessage(ChatColor.GREEN + "Your cake has been planted.");
                        cake.addToList();
                    }
                }
            }
        }
    }
}
