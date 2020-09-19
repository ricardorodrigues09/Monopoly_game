package cards;

import io.Console;
import boardgame.Card;
import monopolygame.MonopolyPlayer;
import monopolygame.MonopolyBoard;


public class CardReceiveMoney extends Card {

	private int amount;


	public CardReceiveMoney(String title, String description, int amount) {
		super(title, description);
		this.amount = amount;
	}


	@Override
	public void cardAction(MonopolyPlayer player, MonopolyBoard board) {

		Console es = new Console();

		if(getName().equals("Anniversaire")) {
			for(int i=0; i<board.getNbPlayers(); i++) {
				if(board.getPlayer(i) != player && !board.getPlayer(i).getIsBankrupt()) {
					board.getPlayer(i).removeMoney(10);
					player.addMoney(10);
				}
			}
			es.println(" > "+player.getName()+" receives 10 euros from each player ");
			
		}
		
		else{
			player.addMoney(amount);
			es.println(" > "+player.getName()+" receives "+amount+"euros from the bank");
		}
	}

	@Override
	public String toString()
	{
		return "CardReceiveMoney [" + super.toString() + " amount= " + amount + "]";
	}

}