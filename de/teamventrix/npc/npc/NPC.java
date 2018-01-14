package de.teamventrix.npc.npc;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;

import de.teamventrix.npc.main.VentrixNPC;

public abstract class NPC {
	
	private String name;
	private Villager entity;
	private Location location;
	private boolean spawned;
	
	public NPC(String name, Location location) {
		setName(name);
		setLocation(location);
		VentrixNPC.npcHandler.addNPC(this);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Villager getEntity() {
		return entity;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public boolean isSpawned() {
		return spawned;
	}
	
	private void setSpawned(boolean spawned) {
		this.spawned = spawned;
	}
	
	public void spawn() {
		if(!isSpawned()) {
			entity = ((Villager)location.getWorld().spawnEntity(location, EntityType.VILLAGER));
			entity.setCustomName(name);
			entity.setCustomNameVisible(true);
			entity.setAgeLock(true);
			entity.setCanPickupItems(false);
			entity.setRemoveWhenFarAway(false);
			setSpawned(true);
		}
	}
	
	public void remove() {
		if(isSpawned()) {
			entity.remove();
			entity = null;
			setSpawned(false);
		}
	}

}
