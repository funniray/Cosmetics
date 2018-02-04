package me.thinkpuppy.emotes;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.thinkpuppy.emotes.inventory.EmotesGUIClick;
import me.thinkpuppy.emotes.listener.CosmeticsGUI;
import me.thinkpuppy.emotes.listener.Emotes;

public class Main extends JavaPlugin{

	@Override
	public void onEnable() {
		
		RegiterEvents();
	}
	private void RegiterEvents() {
		PluginManager pm = getServer().getPluginManager();
	
		pm.registerEvents(new EmotesGUIClick(), this);
		pm.registerEvents(new Emotes(), this);
		pm.registerEvents(new CosmeticsGUI(), this);
	}
}
