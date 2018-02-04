package me.thinkpuppy.emotes.listener;

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
		
		Inventory EmotesGUI = Bukkit.createInventory(null, 9, "Emotes");
		
		ItemStack HappyIcon = nameItem(Material.DIAMOND_CHESTPLATE, ChatColor.LIGHT_PURPLE+ "Happy Emote");
		ItemStack SadIcon = nameItem(Material.DIAMOND_CHESTPLATE, ChatColor.LIGHT_PURPLE+ "Sad Emote");
		ItemStack HugIcon = nameItem(Material.DIAMOND_CHESTPLATE, ChatColor.LIGHT_PURPLE+ "Hug Emote");
		ItemStack DanceIcon = nameItem(Material.DIAMOND_CHESTPLATE, ChatColor.LIGHT_PURPLE+ "Dance Emote");
		ItemStack FoodIcon = nameItem(Material.COOKED_BEEF, ChatColor.LIGHT_PURPLE+ "Eating Food");
		
		EmotesGUI.setItem(2, HappyIcon);
		EmotesGUI.setItem(3, SadIcon);
		EmotesGUI.setItem(4, FoodIcon);
		EmotesGUI.setItem(5, HugIcon);
		EmotesGUI.setItem(6, DanceIcon);
		
		player.closeInventory();
		player.openInventory(EmotesGUI);
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
