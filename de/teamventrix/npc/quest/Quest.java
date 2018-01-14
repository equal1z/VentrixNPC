package de.teamventrix.npc.quest;

import org.bukkit.entity.Player;

import de.teamventrix.npc.npc.QuestNPC;
import de.teamventrix.npc.reward.Reward;

public abstract class Quest {
	
	private String name;
	private Reward reward;
	private int exp;
	private QuestNPC npcTarget;
	
	public Quest(String name, int exp, QuestNPC npcTarget, Reward reward) {
		setName(name);
		setExp(exp);
		setNpcTarget(npcTarget);
		setReward(reward);
	}
	
	public abstract void finish(Player player);
	public abstract void reward(Player player);
	public abstract boolean canFinish(Player player);
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Reward getReward() {
		return reward;
	}

	public void setReward(Reward reward) {
		this.reward = reward;
	}

	public QuestNPC getNpcTarget() {
		return npcTarget;
	}

	public void setNpcTarget(QuestNPC npcTarget) {
		this.npcTarget = npcTarget;
	}

	public int getExp() {
		return exp;
	}
	
	public void setExp(int exp) {
		this.exp = exp;
	}
	
}
