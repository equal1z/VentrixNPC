package de.teamventrix.npc.handler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;

import de.teamventrix.npc.npc.NPC;
import de.teamventrix.npc.npc.QuestNPC;
import de.teamventrix.npc.util.Variable;

public class NPCHandler {
	
	private File npcFile = new File("plugins//VentrixNPC//npcs.yml");
	private YamlConfiguration cfg = YamlConfiguration.loadConfiguration(npcFile);
	private ArrayList<NPC> npcs = new ArrayList<>();
	public boolean spawnedAll = false;
	
	public NPCHandler() {
		loadNPCs();
	}
	
	private void loadNPCs() {
		System.out.println(Variable.PREFIX+"Loading NPCs...");
		int npcCount = 0;
		for(int i = 0; i < cfg.getInt("size"); i++) {
			String name = cfg.getString(i+".name");
			World world = Bukkit.getWorld(cfg.getString(i+".location.world"));
			double x = cfg.getDouble(i+".location.x");
			double y = cfg.getDouble(i+".location.y");
			double z = cfg.getDouble(i+".location.z");
			Location location = new Location(world, x, y, z);
			if(cfg.getString(i+".type").equalsIgnoreCase("QuestNPC")) {
				new QuestNPC(name, location);
			}
			npcCount++;
		}
		System.out.println(Variable.PREFIX+"Loaded "+npcCount+" NPCs");
	}
	
	public void saveNPCs() {
		System.out.println(Variable.PREFIX+"Saving NPCs...");
		for(int i = 0; i < npcs.size(); i++) {
			NPC npc = npcs.get(i);
			Location location = npc.getLocation();
			cfg.set("size", npcs.size());
			cfg.set(i+".name", npc.getName());
			String type = "";
			if(npc instanceof QuestNPC) {
				type = "QuestNPC";
			}
			cfg.set(i+".type", type);
			cfg.set(i+".location.world", location.getWorld().getName());
			cfg.set(i+".location.x", location.getX());
			cfg.set(i+".location.y", location.getY());
			cfg.set(i+".location.z", location.getZ());
		}
		try {
			cfg.save(npcFile);
			System.out.println(Variable.PREFIX+"Saved "+npcs.size()+" NPCs");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addNPC(NPC npc) {
		npcs.add(npc);
	}
	
	public void spawnAll() {
		if(!spawnedAll) {
			for(NPC npc : npcs) {
				npc.spawn();
				spawnedAll = true;
			}
		}
	}
	
	public void despawnAll() {
		if(spawnedAll) {
			for(NPC npc : npcs) {
				npc.remove();
				spawnedAll = false;
			}
		}
	}

}
