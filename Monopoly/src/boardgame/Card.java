package boardgame;


import monopolygame.MonopolyPlayer;
import monopolygame.MonopolyBoard;


/*
 * abstract class
 * defines the title and the description of a card
 * */

public abstract class Card {

	private String title;
	private String description;

	public Card(String title, String description) {
		this.title = title;
		this.description = description;
	}

	
	public String getName() {
		return this.title;
	}

	public String getDesc() {
		return this.description;
	}

	
	public abstract void cardAction(MonopolyPlayer player, MonopolyBoard board);

	@Override
	public String toString() {
		return "Card [title=" + title + ", description=" + description + "]";
	}
}