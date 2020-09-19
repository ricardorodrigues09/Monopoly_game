package places;

import io.Console;
import boardgame.Place;
import monopolygame.MonopolyPlayer;
import monopolygame.MonopolyBoard;

public class PlaceDistributionCompany extends Place {

	private MonopolyPlayer proprietary;
	private boolean answerQuestion = false;

	
	public PlaceDistributionCompany(String name) {
		super(name, 150);
	}

	@Override
	public void actionPlace(MonopolyPlayer player, MonopolyBoard board) {
		
		String answerYN ="";
		Console es = new Console();

		
		if(this.getProprietary() == null) {
			
			es.println("Do you want to buy this Distribution Company?\n");
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
				es.println(" > " + player.getName() + " decides not to buy this company.");
			}
		}

		else if(this.getProprietary() != player)
			payRent(player, board);

		else {
			es.println(" > " + player.getName() + " Owns this company ");
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
			player.setNbCompanies(player.getNbCompanies() + 1);

			System.out.println(" > " + player.getName() + " buys " + this.getName() + " for " + this.getPrice() + "euros");
			return true;
		}
	}


	public void payRent(MonopolyPlayer player, MonopolyBoard board) {
		String beneficiary = "";

		if(!this.getProprietary().getIsPrison()) {

			int rent = board.dice.rollDices();

			if(this.getProprietary().getNbCompanies() == 2) rent*=10;
			else rent*=4;

			System.out.println(" > " + player.getName() + " Rolls the dices... [" + board.dice.getDice1() + "][" + board.dice.getDice2() + "]... and gets " + board.dice.getDices());
			player.removeMoney(rent);

			if(!this.getProprietary().getIsBankrupt()) {
				this.getProprietary().addMoney(rent);
				beneficiary = this.getProprietary().getName();
			}
			System.out.println(" > " + player.getName() + " pays a rent of " + rent + " euros to " + beneficiary);
		}
		else {
			System.out.println(" > The owner is in prison. " + player.getName() + " doesn't pay the rent.");
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
	public void setProprietary(MonopolyPlayer j) {
		this.proprietary = j;
	}

	@Override
	public void setAnswerQuestion(boolean b) {
		this.answerQuestion = b;
	}

	@Override
	public String toString() {
		return "PlaceDistributionCompany [" + super.toString() + ", proprietary=" + (proprietary==null?"null":proprietary.getName()) + "]";
	}

}