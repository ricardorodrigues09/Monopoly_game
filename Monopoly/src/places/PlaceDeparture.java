package places;


import io.Console;
import boardgame.Place;
import monopolygame.MonopolyPlayer;
import monopolygame.MonopolyBoard;



public class PlaceDeparture extends Place {

	
	public PlaceDeparture() {
		super("Depart", 0);
	}

	
	public void actionPlace(MonopolyPlayer player, MonopolyBoard board) {

		Console es = new Console();

		player.addMoney(20000);
		es.println(" > " + player.getName() + " stops at Departure: receives 20000 euros !");
		
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
		return "PlaceDeparture ["+super.toString()+"]";
	}

}