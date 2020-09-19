package places;

import io.Console;
import boardgame.Place;
import monopolygame.MonopolyPlayer;
import monopolygame.MonopolyBoard;

public class PlaceFreePark extends Place {

	
	public PlaceFreePark() {
		super("Parc Gratuit", 0);
	}

	public void actionPlace(MonopolyPlayer player, MonopolyBoard board) {

		Console es = new Console();

		es.println(" > " + player.getName() + " gets " + this.getPrice() + "euros from free parking!");
		player.addMoney(this.getPrice());
		this.setPrice(0);
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
		return false;
	}

	@Override
	public void setProprietary(MonopolyPlayer j) {}

	@Override
	public void setAnswerQuestion(boolean b) {}

	@Override
	public String toString() {
		return "PlaceFreePark [" + super.toString() + "]";
	}

}
