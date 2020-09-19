package boardgame;


import java.util.Random;

/*
 * defines the methods Dices, Dice 1 and Dice2 which respectively return the result of both dices and each one individually
 * */

public class Dice {

	private int dice1;
	private int dice2;
	private Random rand = new Random();

	public int getDices() {
		return (this.dice1 + this.dice2);
	}


	public int getDice1(){
		return this.dice1;
	}

	
	public int getDice2(){
		return this.dice2;
	}

	
	public int rollDices() {
		this.dice1 = 1+this.rand.nextInt(6);
		this.dice2 = 1+this.rand.nextInt(6);

		return getDices();
	}

}