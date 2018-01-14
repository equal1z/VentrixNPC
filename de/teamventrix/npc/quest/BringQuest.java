package de.teamventrix.npc.quest;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import de.teamventrix.npc.npc.QuestNPC;
import de.teamventrix.npc.reward.Reward;

public class BringQuest extends Quest {

	public BringQuest(String name, int exp, QuestNPC npcTarget, Reward reward,
			Material material, int amount) {
		
		super(name, exp, npcTarget, reward);
		
		setMaterial(material);
		setAmount(amount);
	}
	
	private Material material;
	private int amount;
	
	public Material getMaterial() {
		return material;
	}
	
	public void setMaterial(Material material) {
		this.material = material;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public void finish(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reward(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canFinish(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

}
