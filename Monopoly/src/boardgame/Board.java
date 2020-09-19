package boardgame;

import java.util.ArrayList;

/*
 * abstract class board
 * initiates the array of places and the dices
 * defines the numbreOfPlaces and numberOfPlayers
 * sets and defines the activePlayer and the current numberOfRounds
 * 
 * */

public abstract class Board {

	private int activePlayerID = 0;
	private int numberOfPlayers = 2;
	private int numberOfPlaces = 40;
	private int numberOfRounds = 1;

	
	private ArrayList<Place> places = new ArrayList<Place>();
	
	public Dice dice = new Dice();


	public Board(int numberOfPlayers, int numberOfPlaces) {
		this.numberOfPlayers = numberOfPlayers;
		this.numberOfPlaces = numberOfPlaces;
		for(int i=0; i<numberOfPlaces; i++) {
			places.add(null);
		}
	}

	
	public Place getPlace(int i) {
		return this.places.get(i);
	}

	
	public void setPlace(int i, Place caze) {
		this.places.set(i, caze);
		places.get(i).setId(i);
	}

	public int getNbPlaces() {
		return this.numberOfPlaces;
	}

	
	public int getNbPlayers() {
		return this.numberOfPlayers;
	}

	
	public int getActivePlayerID() {
		return this.activePlayerID;
	}

	
	public void setNextPlayer() {
		this.activePlayerID++;
		if(this.activePlayerID >= this.numberOfPlayers) {
			this.activePlayerID = 0;
			this.numberOfRounds++;
		}
	}

	
	public int getNbRounds() {
		return this.numberOfRounds;
	}

	/* Abstract part */

	public abstract boolean endOfGame();
	
	
	public abstract Player isWinner();
}