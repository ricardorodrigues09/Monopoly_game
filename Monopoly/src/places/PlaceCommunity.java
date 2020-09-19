package places;

import boardgame.Card;
import io.Console;
import boardgame.Place;
import monopolygame.MonopolyPlayer;
import monopolygame.MonopolyBoard;

public class PlaceCommunity extends Place {

	public PlaceCommunity() {
		super("Communauté", 0);
	}

	@Override
	public void actionPlace(MonopolyPlayer player, MonopolyBoard board) {
		Console es = new Console();

		Card card = board.takeCardCommunity();
		es.println(" > " + board.getActivePlayer().getName() + " takes the card "+card.getName());
		card.cardAction(board.getActivePlayer(),board);
		
	}

	@SuppressWarnings("static-access")
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
		return false;
	}

	@Override
	public void setProprietary(MonopolyPlayer j) {}

	@Override
	public void setAnswerQuestion(boolean b) {}

	@Override
	public String toString() {
		return "PlaceCommunity [" + super.toString() + "]";
	}

}
