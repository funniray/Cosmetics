package me.thinkpuppy.emotes.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class CosmeticsGUI implements Listener{

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Action a = event.getAction();
		ItemStack is = event.getItem();
		
		if (a == Action.PHYSICAL || is == null || is.getType()== Material.AIR)
			return;
		
		if(is.getType() == Material.CHEST && is.getItemMeta().getDisplayName().equals(ChatColor.GOLD+ "Cosmetics")) {
			
		}

		Player player = (Player) event.getPlayer();
		
		Inventory Cosmetics = Bukkit.createInventory(null, 9, "Cosmetics");
		
		ItemStack Emotes = nameItem(Material.SKULL_ITEM, ChatColor.LIGHT_PURPLE+ "Emotes");
		
		Cosmetics.setItem(0, Emotes);
		
		player.openInventory(Cosmetics);
		
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
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = (Player) event.getPlayer();
		ItemStack Cosmetics = nameItem(Material.CHEST, ChatColor.GOLD+ "Cosmetics");
		player.getInventory().setItem(8, Cosmetics);
	}
	@EventHandler
	public void onItemDropEvent(PlayerDropItemEvent event) {
		if (event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.GOLD+ "Cosmetics")) {
				event.setCancelled(true);
			}
		}
	@EventHandler
	public void onItemPlace(BlockPlaceEvent event) {
		if (event.getBlockPlaced().getType().equals(Material.CHEST)) {
			event.setCancelled(true);
	}
	}
}
