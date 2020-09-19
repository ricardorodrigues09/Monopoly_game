package monopolygame;

import java.util.ArrayList;
import boardgame.Place;
import boardgame.Player;


public class MonopolyPlayer extends Player {

	private int money = 150000;
	private boolean isBankrupt = false;
	private boolean isPrison = false;
	private int roundsInPrison = 1;
	private boolean hasCardLeavePrison = false;
	private int numberOfStationsOwned = 0;
	private int numberOfCompaniesOwned = 0;
	private ArrayList<Place> lands = new ArrayList<Place>();
	private ArrayList<String> colors = new ArrayList<String>();


	public MonopolyPlayer(String name, int id, int money) {
		super(name, id);
		this.money = money;
	}

	public int getRoundsInPrison() {
		return roundsInPrison;
	}

	public void setRoundsInPrison(int roundsEnPrison) {
		this.roundsInPrison = roundsEnPrison;
	}

	public boolean getIsPrison(){
		return this.isPrison;
	}

	public void setIsPrison(boolean prison){
		this.isPrison = prison;
	}


	public boolean getCardLeavePrison() {
		return hasCardLeavePrison;
	}

	
	public void setCardLeavePrison(boolean b) {
		hasCardLeavePrison = b;
	}

	/*  PROPRIETIES PART  */

		// STATIONS AND SERVICES

	
	public int getNbStations() {
		return this.numberOfStationsOwned;
	}


	public void setNbStations(int nb) {
		this.numberOfStationsOwned = nb;
	}


	public int getNbCompanies() {
		return this.numberOfCompaniesOwned;
	}


	public void setNbCompanies(int nb) {
		this.numberOfCompaniesOwned = nb;
	}

		// LANDS


	public void addLand(Place land) {
		this.lands.add(land);
	}


	public String getListStringLands() {
		String s = "";
		for(Place t:this.lands) {
			s+=(t.getName()+",");
		}
		return s;
	}


	public ArrayList<Place> getListLands(){
		return this.lands;
	}

	// Colors

	public ArrayList<String> getListColor(){

		colors.clear();

		int 	brown = 0,
				turquoise = 0,
				mauve = 0,
				orange = 0,
				red = 0,
				yellow = 0,
				green = 0,
				blue = 0;

		for(Place t:this.getListLands()) {

			if(t.getColor() == "brown")
				brown += 1;
			if(t.getColor() == "turquoise")
				turquoise += 1;
			if(t.getColor() == "mauve")
				mauve += 1;
			if(t.getColor() == "orange")
				orange += 1;
			if(t.getColor() == "red")
				red += 1;
			if(t.getColor() == "yellow")
				yellow += 1;
			if(t.getColor() == "green")
				green += 1;
			if(t.getColor() == "blue")
				blue += 1;
		}

		if(brown == 2) 		colors.add("brown");

		if(turquoise == 3) 	colors.add("turquoise");

		if(mauve == 3) 		colors.add("mauve");

		if(orange == 3) 	colors.add("orange");

		if(red == 3) 		colors.add("red");

		if(yellow == 3)		colors.add("yellow");

		if(green == 3) 		colors.add("green");

		if(blue == 2) 		colors.add("blue");

		return this.colors;
	}

	/* MONEY PART */


	public int getMoney() {
		return this.money;
	}


	public void addMoney(int amount) {
		this.money+=amount;
	}

	
	public void removeMoney(int amount) {
		this.money = this.money - amount;
		if(this.money <= 0) {
			this.money = 0;
			this.setIsBankrupt(true);
		}
	}

	public boolean getIsBankrupt() {
		return this.isBankrupt;
	}


	public void setIsBankrupt(boolean bankrupt) {
		this.isBankrupt = bankrupt;
		clearMarkers();
		this.lands.clear();
	}


	public void clearMarkers() {

		for(Place t:getListLands()){
			t.setProprietary(null);

		}
	}

	@Override
	public String toString() {
		return "MonopolyPlayer [" + super.toString() + ", money =" + money + ", isBankrupt =" + isBankrupt + ", isPrison=" + isPrison
				+ ", roundsInPrison=" + roundsInPrison + ", hasCardLeavePrison=" + hasCardLeavePrison
				+ ", numberOfStationsOwned =" + numberOfStationsOwned + ", numberOfCompaniesOwned ="
				+ numberOfCompaniesOwned + ", \nlands=[" + getListStringLands() + "], \ncolors=" + getListColor() + "]";
	}
}
