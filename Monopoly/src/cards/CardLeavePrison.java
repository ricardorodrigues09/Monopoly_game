package cards;

import io.Console;
import boardgame.Card;
import monopolygame.MonopolyPlayer;
import monopolygame.MonopolyBoard;

public class CardLeavePrison extends Card {

	public CardLeavePrison(String title, String description) {
		super(title, description);
	}

	@Override
	public void cardAction(MonopolyPlayer player, MonopolyBoard board) {
		
		Console es = new Console();
		es.println(" > "+player.getName()+" receives the card 'Leave Prison'!");
		
		player.setCardLeavePrison(true);
	}
	@Override
	public String toString() {
		return "CardLeavePrison [" + super.toString() +"]";
	}
}
