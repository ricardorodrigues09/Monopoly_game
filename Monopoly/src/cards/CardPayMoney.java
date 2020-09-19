package cards;

import io.Console;
import boardgame.Card;
import monopolygame.MonopolyPlayer;
import monopolygame.MonopolyBoard;


public class CardPayMoney extends Card {
	
	private int amount;
	

	public CardPayMoney(String title, String description, int amount) {
		super(title, description);
		this.amount=amount;
	}

	@Override
	public void cardAction(MonopolyPlayer player, MonopolyBoard board) {
		
		Console es = new Console();
		
		if(getName().equals("Président du conseil d'administration")) {
			for(int i=0; i<board.getNbPlayers(); i++) {
				if(board.getPlayer(i) != player && !board.getPlayer(i).getIsBankrupt()) {
					board.getPlayer(i).addMoney(50);
					player.removeMoney(50);
				}
			}
			es.println(" > "+player.getName()+" pays 50 euros to each player");
		}
		else {
			player.removeMoney(amount);
			board.getPlace(20).setPrice(board.getPlace(20).getPrice() + amount);
			es.println(" > "+player.getName()+" pays "+amount+" euros to free parking");
			}
	}
	public int getAmount(){
		return this.amount;
	}

	@Override
	public String toString() {
		return "CardPayMoney ["+ super.toString() +", amount = " + amount + "]";
	}
}