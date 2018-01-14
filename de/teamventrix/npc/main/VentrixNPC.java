package de.teamventrix.npc.main;

import org.bukkit.plugin.java.JavaPlugin;

import de.teamventrix.npc.handler.NPCHandler;

public class VentrixNPC extends JavaPlugin {
	
	public static NPCHandler npcHandler;
	private boolean enabled;
	
	@Override
	public void onEnable() {
		init();
	}
	
	private void init() {
		enabled = true;
		npcHandler = new NPCHandler();
		npcHandler.spawnAll();
	}
	
	@Override
	public void onDisable() {
		if(enabled) {
			npcHandler.saveNPCs();
			npcHandler.despawnAll();
		}
	}

}
