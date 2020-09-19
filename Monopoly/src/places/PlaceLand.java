package places;

import java.util.ArrayList;
import io.Console;
import boardgame.Place;
import monopolygame.MonopolyBoard;
import monopolygame.MonopolyPlayer;

public class PlaceLand extends Place {

	private MonopolyPlayer proprietary;
	private ArrayList<Integer> rent = new ArrayList<Integer>();
	private String color;
	private int priceHouse;
	private int nbHouses = 0;
	private boolean canPutHouse = false;
	private boolean answerQuestion = false;


	public PlaceLand(String name, int value, ArrayList<Integer> rent, int priceHouse, int nbHouses, String color) {
		super(name, value);
		this.color = color;
		this.rent = rent;
		this.priceHouse = priceHouse;
		this.nbHouses = nbHouses;
	}


	public void actionPlace(MonopolyPlayer player, MonopolyBoard board) {

		String answerYN ="";
		Console es = new Console();
		
		if(this.getProprietary() == null) {
			es.println("Do you want to buy this land?\n");
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
				es.println(" > " + player.getName() + " Decides not to buy this land");
			}
		}

		else if(this.getProprietary() != player)
			payRent(player);

		else {
			es.println(" > " + player.getName() + " is on his own land");

			if(this.getCanPutHouse(board, es)) { 
				es.println("You own " + getNbHouses() + " houses in this land. Do you want to build a house/hotel?\n");
				while (!(answerYN.equals("y") || answerYN.equals("n"))) {
					es.println("Please introduce y/n.\n");
					try {
						answerYN=es.strInput();
					}
					catch(Exception e){
						es.println("Please introduce a valid answer");
					}
				}
				if (answerYN.equals("y")) {
					this.addHouse(board);
					es.println(" > " + player.getName() + " now owns " + getNbHouses() + " houses " + (getNbHouses()>0?"s":"") + " in this land");
				}
			}
		}
	}


	public boolean buyLand(MonopolyPlayer player) {
		if((player.getMoney() - this.getPrice()) <= 0) {
			System.out.println("You don't have enough money");
			return false;
		}
		else {
			setProprietary(player);
			player.addLand(this);
			player.removeMoney(this.getPrice());
			System.out.println(" > " + player.getName() + " buys " + this.getName() + " for " + this.getPrice() + "euros ");
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
			System.out.println(" > The owner is in prison. " + player.getName() + " doesn't pay rent.");
		}
	}

	public void addHouse(MonopolyBoard board){
		
		board.demolishHouse(1);
		nbHouses++;
		proprietary.removeMoney(this.getPriceHouse());

		if(this.nbHouses <=4 ){
			System.out.println(" > " + proprietary.getName() + " placed a house in "+getName()+" !");
		}
		else{
			board.demolishHouse(4);
			System.out.println(" > " + proprietary.getName() + " Placed a hotel in "+getName()+" and can no longer place here buildings!");
		}
	}

	

	public boolean getCanPutHouse(MonopolyBoard board, Console es) {
		if(proprietary.getListColor().contains(this.getColor())){

			ArrayList<Place> color = new ArrayList<Place>();
			for(Place c: proprietary.getListLands())
				if(c.getColor() == this.getColor() && c != this)
					color.add(c);

			this.canPutHouse = true;
			for(Place c:color) {
				if(!(this.getNbHouses() == c.getNbHouses() || this.getNbHouses() == c.getNbHouses() - 1)) {
					this.canPutHouse = false;
					break;
				}
			}

			if(proprietary.getMoney() < this.getPriceHouse()) {
				this.canPutHouse = false;
				System.out.println("You don't have enoughmoney to build !");
			}
			if(getNbHouses() == 5) {
				this.canPutHouse = false;
				System.out.println("The maximum of buildings for this land has been hit!");
			}
			if (getNbHouses()<4 && board.getHousesLeft()==0) {
				es.println("No more houses can be built: 32 houses already on the board");
				this.canPutHouse = false;
			}
			if (getNbHouses()==4 && board.getHotelsLeft()==0) {
				es.println("No more houses can be built: 12 hotels on the board");
				this.canPutHouse = false;
			}
		}
		else
			this.canPutHouse = false;

		return this.canPutHouse;
	}
	
	
	/* ===========================
	   abstract methods
	   =========================== */

	@Override
	public int getRent() {
		int toPay = rent.get(getNbHouses());
		if(proprietary.getListColor().contains(this.getColor()) && getNbHouses() == 0)
			toPay*=2;

		return toPay;
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public int getPriceHouse() {
		return priceHouse;
	}

	@Override
	public int getNbHouses() {
		return nbHouses;
	}
	public void setNbHouses(int i) {
		this.nbHouses = i;
	}

	@Override
	public MonopolyPlayer getProprietary() {
		return proprietary;
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
		return "PlaceLand ["+ super.toString() +", proprietary=" + (proprietary==null?"null":proprietary.getName()) + ", color=" + color + ", rent=" + rent
				+ ", priceHouse=" + priceHouse + ", canPutHouse=" + canPutHouse + ", nbHouses=" + nbHouses + "]";
	}

}
