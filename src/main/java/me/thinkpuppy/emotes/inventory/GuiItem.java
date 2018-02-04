package me.thinkpuppy.emotes.inventory;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GuiItem {

    private String name;
    private String message;
    private ItemStack item;

    public GuiItem(String name, String message, Material material){
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);

        this.item = item;
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ItemStack getItem() {
        return item;
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }
}
