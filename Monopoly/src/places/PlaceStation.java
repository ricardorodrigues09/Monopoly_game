package places;


import io.Console;
import boardgame.Place;
import monopolygame.MonopolyPlayer;
import monopolygame.MonopolyBoard;


public class PlaceStation extends Place {

	private MonopolyPlayer proprietary;
	private boolean answerQuestion = false;

	
	public PlaceStation(String name) {
		super(name, 200);
	}

	
	/**
	 * Needs to be changed
	 
	 */
	@Override
	public void actionPlace(MonopolyPlayer player, MonopolyBoard board) {
		
		String answerYN ="";
		Console es = new Console();
		
		if(this.getProprietary() == null) {
		
			es.println("Do you want to buy this station?\n");
			while (!(answerYN.equals("y") || answerYN.equals("n"))) {
				es.println("Please introduce y/n.\n");
				try {
					answerYN=es.strInput();
				}
				catch(Exception e){
					es.println("Please introduce a valid answer");
				}
			}
		
			if(answerYN.equals("y")) {
				answerQuestion = true;
			
			}

		
			if(getAnswerQuestion()) {
				buyLand(player);
				
			}
			else {
				es.println(" > " + player.getName() + " decides not to buy this station.");
			}
		}
		else if(this.getProprietary() != player)
			payRent(player);

		else {
			es.println(" > " + player.getName() + " is in his own station.");
			
		}
	}


	public boolean buyLand(MonopolyPlayer player) {
		if((player.getMoney() - this.getPrice()) <= 0) {
			System.out.println("You don't have enough money!");
			return false;
		}
		else {
			setProprietary(player);
			player.addLand(this);
			player.removeMoney(this.getPrice());
			player.setNbStations(player.getNbStations() + 1);

			System.out.println(" > " + player.getName() + " buys " + this.getName() + " for " + this.getPrice() + "euros");
			return true;
		}
	}

	public void payRent(MonopolyPlayer player) {
		String beneficiary = "";

		if(!this.getProprietary().getIsPrison()) {

			player.removeMoney(getRent());

			if(!this.getProprietary().getIsBankrupt()) {
				this.getProprietary().addMoney(getRent());
				beneficiary = this.getProprietary().getName();
			}
			System.out.println(" > " + player.getName() + " pays a rent of " + getRent() + "euros to " + beneficiary);
			
		}
		else {
			System.out.println(" >The proprietary is in prison. " + player.getName() + " does not pay the rent.");
			
		}
	}

	@Override
	public MonopolyPlayer getProprietary() {
		return proprietary;
	}

	@Override
	public String getColor() {
		return null;
	}

	@Override
	public int getRent() {
		return proprietary != null ? 50 * this.getProprietary().getNbStations() : 0;
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
	public void setProprietary(MonopolyPlayer j) {
		this.proprietary = j;
	}

	@Override
	public void setAnswerQuestion(boolean b) {
		this.answerQuestion = b;
	}

	@Override
	public String toString() {
		return "PlaceStation [" + super.toString() + ", proprietary=" + (proprietary==null?"null":proprietary.getName()) + "]";
	}


}
