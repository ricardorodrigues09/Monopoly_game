package boardgame;

import monopolygame.MonopolyPlayer;
import monopolygame.MonopolyBoard;

/*
 * abstract class
 * defines the name, the id and the value (associated) to a place
 * it has all the abstract methods of the places */
public abstract class Place {

	private String name;
	private int id = 0;
	private int value = 0;


	public Place(String name, int value) {
		this.name = name;
		this.value = value;
	}


	public String getName() {
		return name;
	}

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getPrice() {
		return value;
	}

	public void setPrice(int value) {
		this.value = value;
	}

	public abstract MonopolyPlayer getProprietary();


	public abstract String getColor();


	public abstract int getRent();

	
	public abstract int getPriceHouse();


	public abstract int getNbHouses();


	public abstract boolean getAnswerQuestion();

	
	public abstract void setProprietary(MonopolyPlayer j);


	public abstract void setAnswerQuestion(boolean b);
	
	
	public abstract void actionPlace(MonopolyPlayer player, MonopolyBoard board);


	@Override
	public String toString() {
		return "Place [name=" + name + ", id=" + id + ", value=" + value + "]";
	}

}
