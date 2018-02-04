package me.thinkpuppy.emotes.inventory;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class EmotesGUI {

    private HashMap<ItemStack,GuiItem> GuiItems = new HashMap<>();

    public static Inventory emoteGui;

    public EmotesGUI(){
        emoteGui = Bukkit.createInventory(null,9,"Emotes");

        addGuiItem(new GuiItem(ChatColor.LIGHT_PURPLE+ "Happy Emote",ChatColor.LIGHT_PURPLE+ "%player%" + ChatColor.AQUA+ " Is happy, you're a great person for being there for them.",Material.DIAMOND_CHESTPLATE),2);
        addGuiItem(new GuiItem(ChatColor.LIGHT_PURPLE+ "Sad Emote",ChatColor.LIGHT_PURPLE+ "%player%" + ChatColor.AQUA+ " Is currently sad, you should talk to them.",Material.DIAMOND_CHESTPLATE),3);
        addGuiItem(new GuiItem(ChatColor.LIGHT_PURPLE+ "Eating Food",ChatColor.LIGHT_PURPLE+ "%player%" + ChatColor.AQUA+ " Is munching on some food. "+ ChatColor.GOLD+ ChatColor.BOLD+ "OM NOM NOM!", Material.COOKED_BEEF),4);
        addGuiItem(new GuiItem(ChatColor.LIGHT_PURPLE+ "Hug Emote",ChatColor.LIGHT_PURPLE+ "%player%" + ChatColor.AQUA+ " Is putting their hands out for a hug.",Material.DIAMOND_CHESTPLATE),5);
        addGuiItem(new GuiItem(ChatColor.LIGHT_PURPLE+ "Dance Emote",ChatColor.LIGHT_PURPLE+ "%player%" + ChatColor.AQUA+ " Wants to dance, come out onto the dance floor with them!",Material.DIAMOND_CHESTPLATE),6);
    }

    private void addGuiItem(GuiItem item, int slot){
        ItemStack itemStack = item.getItem();
        GuiItems.put(itemStack,item);
        emoteGui.setItem(slot,itemStack);
    }

    public GuiItem getGuiItem(ItemStack item){
        return GuiItems.get(item);
    }

}
