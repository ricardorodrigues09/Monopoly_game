package places;


import io.Console;
import boardgame.Place;
import monopolygame.MonopolyPlayer;
import monopolygame.MonopolyBoard;

public class PlaceTaxes extends Place {


	public PlaceTaxes(String name, int value) {
		super(name, value);
	}

	
	public void actionPlace(MonopolyPlayer player, MonopolyBoard board) {

		Console es = new Console();

		es.println(" > " + player.getName() + " deposits " + this.getPrice() + "euros to Free Park.");
		

		player.removeMoney(this.getPrice());

		int newAmountFreePark = board.getPlace(20).getPrice() + this.getPrice();
		board.getPlace(20).setPrice(newAmountFreePark);
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

}