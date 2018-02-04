package me.thinkpuppy.emotes.inventory;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

public class EmotesGUIClick implements Listener{

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Inventory inv = event.getClickedInventory();
		
		if(inv.getTitle().equals("Emotes")) {
		
		Player player = (Player) event.getWhoClicked();
		ItemStack item = event.getCurrentItem();
		if (item.getType() == Material.COOKED_BEEF) {
			if (item.getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE+ "Eating Food")) {
				Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE+ event.getWhoClicked().getName() + ChatColor.AQUA+ " Is munching on some food. "+ ChatColor.GOLD+ ChatColor.BOLD+ "OM NOM NOM!");
			}
			event.setCancelled(true);
			player.closeInventory();
		}
		
		if (item.getType() == Material.DIAMOND_CHESTPLATE) {
			if (item.getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE+ "Happy Emote")) {
				Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE+ event.getWhoClicked().getName() + ChatColor.AQUA+ " Is happy, you're a great person for being there for them.");
			}
			if (item.getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE+ "Sad Emote")) {
				Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE+ event.getWhoClicked().getName() + ChatColor.AQUA+ " Is currently sad, you should talk to them.");
			}
			if (item.getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE+ "Hug Emote")) {
				Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE+ event.getWhoClicked().getName() + ChatColor.AQUA+ " Is putting their hands out for a hug.");
			}
			if (item.getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE+ "Dance Emote")) {
				Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE+ event.getWhoClicked().getName() + ChatColor.AQUA+ " Wants to dance, come out onto the dance floor with them!");
			}
			event.setCancelled(true);
			player.closeInventory();
		}
	}
	}
}
