package places;

import io.Console;
import boardgame.Place;
import monopolygame.MonopolyPlayer;
import monopolygame.MonopolyBoard;


public class PlaceGoToPrison extends Place {

	private boolean answerQuestion = false;

	
	public PlaceGoToPrison() {
		super("Aller en prison", 0);
	}

	public void actionPlace(MonopolyPlayer player, MonopolyBoard board) {

		Console es = new Console();

		if(player.getCardLeavePrison()) {
			es.println(" > " + player.getName() + " uses this card to avoid prison!");
			board.putCardLeavePrisonIntoDeck();
		}
		else {
			player.setIsPrison(true);
			player.setPosition(10);
			es.println(" > " + player.getName() + " is sent to prison!");
		}
	}

	@Override
	public MonopolyPlayer getProprietary() {
		return null;
	}

	@Override
	public String getColor() {
		return null;
	}

	@Override
	public int getRent() {
		return 0;
	}

	@Override
	public int getPriceHouse() {
		return 0;
	}

	@Override
	public int getNbHouses() {
		return 0;
	}

	@Override
	public boolean getAnswerQuestion() {
		return answerQuestion;
	}

	@Override
	public void setProprietary(MonopolyPlayer j) {}

	@Override
	public void setAnswerQuestion(boolean b) {
		this.answerQuestion = b;
	}

	@Override
	public String toString() {
		return "PlaceGoToPrison [" + super.toString() + "]";
	}

}
