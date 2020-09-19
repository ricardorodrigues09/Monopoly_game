package cards;

import io.Console;
import boardgame.Card;
import monopolygame.MonopolyPlayer;
import monopolygame.MonopolyBoard;
/*
 * Specific class of the abstract Card
 * Uses the current position (destination) and the relativeMovement*/
public class CardMove extends Card {
	
	
	private int position;
	private boolean relativeMovement;
	
	public CardMove(String title, String description, int pos, boolean relativeMovement) {
		super(title, description);
		this.position = pos;
		this.relativeMovement = relativeMovement;
	}


	@Override
	public void cardAction(MonopolyPlayer player, MonopolyBoard board) {
		
		Console es = new Console();
		
		if(relativeMovement)
			board.movePlayer(player, position);
		else {
			if(getName().equals("Prison")) { //If the card to move is the one to go to prison
				if(player.getCardLeavePrison()) { // and if the player has the card to avoid prison
					es.println(" > " + player.getName() + " uses the card leave prison that he got before to avoid prison !");
					player.setCardLeavePrison(false);
					board.putCardLeavePrisonIntoDeck(); // he loses that card and nothing else happens
				}
				else {
					player.setIsPrison(true); //if he doesn't have the card to avoid prison he goes to prison and nothing else happens (doesn't get the salary if he passes by the start)
					board.movePlayer(player, position-player.getPosition());
					es.println(" > "+player.getName()+" goes to Prison");
				}
			}
			else if(position-player.getPosition()<0) //if between the current position and the destination he passes thought the starting place
				board.movePlayer(player, position-player.getPosition()+40);//he just goes and the other part is just a formula to get there
			else
				board.movePlayer(player, position-player.getPosition());//if he doesn't pass through the start he just goes to his destination
		}
		
		if(getName().equals("Prison")) {
			
		}
		else {
			es.println(" > "+player.getName()+" is now in "+ board.getPlaceActive().getName());
			
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			board.getPlace(player.getPosition()).actionPlace(player, board);
		}
		
	}
	@Override
	public String toString() {
		return "CardMove [" + super.toString() + "]";
	}
}
