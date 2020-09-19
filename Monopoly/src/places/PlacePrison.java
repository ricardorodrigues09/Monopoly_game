package places;



import io.Console;
import boardgame.Place;
import monopolygame.MonopolyPlayer;
import monopolygame.MonopolyBoard;


public class PlacePrison extends Place {

	private boolean answerQuestion = false;

	public PlacePrison() {
		super("Simple Visite", 0);
	}

	public void actionPlace(MonopolyPlayer player, MonopolyBoard board) {

		Console es = new Console();


		int resultdices = board.dice.rollDices();
		int d1 = board.dice.getDice1();
		int d2 = board.dice.getDice2();

		if(player.getIsPrison() == true){
			
			if(player.getRoundsInPrison() > 2) {
				if(d1 == d2){
					es.println("  [" + d1 + "][" + d2 + "] Won! " + player.getName() + " can leave prison without paying!");
					player.setIsPrison(false);
					player.setRoundsInPrison(1);
					board.movePlayer(player, resultdices);
					es.println("" + player.getName() + " moves " + resultdices + " boxes and stops at " + board.getPlaceActive().getName());
					
				}
				else{
					es.println("" + player.getName() + " rolls the dices... [" + d1 + "][" + d2 + "]... and obtains a " + resultdices + " !");
					es.println("" + player.getName() + " Lost!");
					es.println("" + player.getName() + " failed to roll a double for the 3rd time, leaves and pays 5000 euros.");
					player.removeMoney(5000);
					es.println(" > " + player.getName() + " deposits 5000 euros to Free Park.");
					int newAmountFreePark = board.getPlace(20).getPrice() + 5000;
					board.getPlace(20).setPrice(newAmountFreePark);
					player.setIsPrison(false);
					player.setRoundsInPrison(1);
					board.movePlayer(player, resultdices);
					es.println("" + player.getName() + " moves " + resultdices + " boxes and stops at " + board.getPlaceActive().getName());
					
				}
				
				
			}
			else{
				es.println("" + player.getName() + " (round " + player.getRoundsInPrison() + ") rolls the dices...");
				if(d1 == d2){
					es.println("  [" + d1 + "][" + d2 + "] Won! " + player.getName() + " can leave prison without paying!");
					player.setIsPrison(false);
					player.setRoundsInPrison(1);
					board.movePlayer(player, resultdices);
					es.println("" + player.getName() + " moves " + resultdices + " boxes and stops at " + board.getPlaceActive().getName());
					
				}
				else{
					es.println("  [" + d1 + "][" + d2 + "] Lost! Try again next time");
					player.setRoundsInPrison(player.getRoundsInPrison() + 1);
				}
				
			}
		}
		else{
			es.println(" > The player observes the criminals...");
		
		}
	
	}


	
	/**
	 * Needs to be changed
	 
	 */
	public void actionLeavePrison(MonopolyBoard board, MonopolyPlayer player){

		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		board.getPlace(player.getPosition()).actionPlace(player, board);
	}

	

	@Override
	public MonopolyPlayer getProprietary() {
		return null;
	}

	@Override
	public String getColor() {
		return null;
	}

	@Override
	public int getRent() {
		return 0;
	}

	@Override
	public int getPriceHouse() {
		return 0;
	}

	@Override
	public int getNbHouses() {
		return 0;
	}

	@Override
	public boolean getAnswerQuestion() {
		return answerQuestion;
	}


	@Override
	public void setProprietary(MonopolyPlayer j) {}

	@Override
	public void setAnswerQuestion(boolean b) {
		this.answerQuestion = b;
	}

	@Override
	public String toString() {
		return "PlacePrison [ " + super.toString() + ", answerQuestion=" + answerQuestion + "]";
	}

}