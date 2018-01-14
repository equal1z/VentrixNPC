package de.teamventrix.npc.npc;

import java.util.ArrayList;

import org.bukkit.Location;

import de.teamventrix.npc.quest.Quest;

public class QuestNPC extends NPC {

	public QuestNPC(String name, Location location) {
		super(name, location);
	}
	
	private final ArrayList<Quest> quests = new ArrayList<>();
	
	public void addQuest(Quest quest) {
		quests.add(quest);
	}

	public ArrayList<Quest> getQuests() {
		return quests;
	}

}
