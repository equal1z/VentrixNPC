package de.teamventrix.npc.reward;

public class Reward {
	
	private RewardType type;
	private int amount;
	
	public Reward(RewardType type, int amount) {
		setType(type);
		setAmount(amount);
	}
	
	public RewardType getType() {
		return type;
	}
	
	public void setType(RewardType type) {
		this.type = type;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
