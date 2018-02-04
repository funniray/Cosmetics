package me.thinkpuppy.emotes.listener;

import me.thinkpuppy.emotes.inventory.EmotesGUI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class Emotes implements Listener{

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Inventory inv = event.getClickedInventory();

		if(inv.getTitle().equals("Cosmetics")) {
		
		Player player = (Player) event.getWhoClicked();
		ItemStack item = event.getCurrentItem();
			if (item.getType() == Material.SKULL_ITEM) {
				player.closeInventory();
				player.openInventory(EmotesGUI.emoteGui);
			}
		}
	}
	private ItemStack nameItem(ItemStack item, String name) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		return item;
	}
	private ItemStack nameItem(Material item, String name) {
		return nameItem(new ItemStack(item), name);
	}
}
