package main;

import boardgame.*;
import cards.*;
import io.*;
import monopolygame.*;
import places.*;



public class Main {
	private static int nPlayers=0;

	public static void main(String[] args) {
		
		Console es = new Console();
		es.println("\nMONOPOLY\n");
		
		while(nPlayers<2 || nPlayers>6){
			es.println("Introduce the number of players between 2 and 6");
			try {
				nPlayers=es.readInt();
			}
			catch(Exception e){
				es.println("Please introduce a valid number of players");
			}
		}
		MonopolyBoard board = new MonopolyBoard (nPlayers);
		
		MonopolyPlayer player;
		int rollDices;
		Place currentPlace;
		
		while (!board.endOfGame() && board.getNbRounds() <= 100){
			player = board.getActivePlayer();
			
			if(board.getActivePlayerID() == 0)
				es.println(" Round " + board.getNbRounds());

			es.println("It is  " + player.getName() + "'s turn (he has " + player.getMoney() + "euros).");
			
			boolean playing = true;
			while (playing) {
				playing=false;
				if(!player.getIsBankrupt()) {

					rollDices = board.dice.rollDices();

					if(!player.getIsPrison()) {

						es.println("" + player.getName() + " rolls the dices... [" + board.dice.getDice1() + "][" + board.dice.getDice2() + "]... which results in " + rollDices + " !");
						board.movePlayer(player, rollDices);
					
						currentPlace = board.getPlace(player.getPosition());
						es.println("" + player.getName() + " moves " + rollDices + " places and ends in " + currentPlace.getName());
						currentPlace.actionPlace(player, board);
						if (board.dice.getDice1()==board.dice.getDice2() && !player.getIsPrison()) {
							playing=true;
							es.println("Rolled double, play again!");
						}
					
					}
					else {
						es.println("The Player is in Prison.");

						currentPlace = board.getPlace(player.getPosition());
						currentPlace.actionPlace(player, board);
					}

				

					es.println("" + player.getName() + " has " + player.getMoney() + "euros at the end of his turn");
					System.out.println("and the following lands :\n" + player.getListStringLands());
				}
				else {
					es.println("" + board.getActivePlayer().getName() + " Is Bankrupt, He can't play.");
				}
			}

			board.setNextPlayer();
		}
		
		es.println("END OF THE GAME");
		es.println(" The winner is " + board.isWinner().getName() + " !");

	}

}
