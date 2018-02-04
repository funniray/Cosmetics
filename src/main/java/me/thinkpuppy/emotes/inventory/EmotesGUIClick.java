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
import org.bukkit.plugin.Plugin;

public class EmotesGUIClick implements Listener{

	EmotesGUI emotes;
	Plugin plugin;

	public EmotesGUIClick(Plugin plugin){
		this.emotes = new EmotesGUI();
		this.plugin = plugin;
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Inventory inv = event.getClickedInventory();
		
		if(inv.getTitle().equals("Emotes")) {
			Player player = (Player) event.getWhoClicked();
			ItemStack item = event.getCurrentItem();

			GuiItem guiItem = emotes.getGuiItem(item);

			if (guiItem != null) {
				plugin.getServer().broadcastMessage(guiItem.getMessage().replace("%player%", player.getDisplayName()));
				event.setCancelled(true);
				player.closeInventory();
			}
		}
	}
}
