package monopolygame;

/*
 * specific class to define and create the MonopolyBoard
 * uses the array of players, array of cards (community and chance)
 * uses the setPlace defined in board.java to create all the places of the MonopolyBoard
 * */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import cards.*;
import places.PlaceGoToPrison;
import places.PlaceChance;
import places.PlaceCommunity;
import places.PlaceDeparture;
import places.PlaceStation;
import places.PlaceTaxes;
import places.PlaceFreePark;
import places.PlacePrison;
import places.PlaceDistributionCompany;
import places.PlaceLand;
import boardgame.Card;
import boardgame.Place;
import boardgame.Player;


public class MonopolyBoard extends boardgame.Board {

	

	private ArrayList<MonopolyPlayer> players = new ArrayList<MonopolyPlayer>();
	
	private ArrayList<Card> chance = new ArrayList<Card>();
	private ArrayList<Card> community = new ArrayList<Card>();
	private int housesLeft = 32;
	private int hotelsLeft = 12;


	public MonopolyBoard(int numberOfPlayers) {
		super(numberOfPlayers, 40);



		for(int i = 0; i < this.getNbPlayers(); i++) {
			this.players.add(new MonopolyPlayer("Player"+(i+1), i, 150000));
		}

		/* Initialization of places*/
		setPlace(0, new PlaceDeparture());
		setPlace(2, new PlaceCommunity());
		setPlace(4, new PlaceTaxes("Impôts sur le revenu", 200));
		setPlace(5, new PlaceStation("Gare Mont-Parnasse"));
		setPlace(7, new PlaceChance());
		setPlace(10, new PlacePrison());
		setPlace(12, new PlaceDistributionCompany("Compagnie d'électricité"));
		setPlace(15, new PlaceStation("Gare de Lyon"));
		setPlace(17, new PlaceCommunity());
		setPlace(20, new PlaceFreePark());
		setPlace(22, new PlaceChance());
		setPlace(25, new PlaceStation("Gare du Nord"));
		setPlace(28, new PlaceDistributionCompany("Compagnie de distribuition des eaux"));
		setPlace(30, new PlaceGoToPrison());
		setPlace(33, new PlaceCommunity());
		setPlace(35, new PlaceStation("Gare Saint-Lazare"));
		setPlace(36, new PlaceChance());
		setPlace(38, new PlaceTaxes("Taxe de Luxe", 100));

		/* Initialization of lands */
		setPlace(1, new PlaceLand("Boulevard de Belleville", 60, new ArrayList<Integer>(Arrays.asList(2, 10, 30, 90, 160, 250)), 50, 0, "brown"));
		setPlace(3, new PlaceLand("Rue Lecourbe", 60, new ArrayList<Integer>(Arrays.asList(4, 20, 60, 180, 320, 450)), 50, 0, "brown"));

		setPlace(6, new PlaceLand("Rue de Vaugirard", 100, new ArrayList<Integer>(Arrays.asList(6, 30, 90, 270, 400, 550)), 50, 0, "turquoise"));
		setPlace(8, new PlaceLand("Rue de Courcelles", 100, new ArrayList<Integer>(Arrays.asList(6, 30, 90, 270, 400, 550)), 50, 0, "turquoise"));
		setPlace(9, new PlaceLand("Avenue de la République", 120, new ArrayList<Integer>(Arrays.asList(8, 40, 100, 300, 450, 600)), 50, 0, "turquoise"));

		setPlace(11, new PlaceLand("Boulevard la Villette", 140, new ArrayList<Integer>(Arrays.asList(10, 50, 150, 450, 625, 750)), 100, 0, "mauve"));
		setPlace(13, new PlaceLand("Avenue de Neuilly", 140, new ArrayList<Integer>(Arrays.asList(10, 50, 150, 450, 625, 750)), 100, 0, "mauve"));
		setPlace(14, new PlaceLand("Rue du Paradis", 160, new ArrayList<Integer>(Arrays.asList(12, 60, 180, 500, 700, 900)), 100, 0, "mauve"));

		setPlace(16, new PlaceLand("Avenue Mozart", 180, new ArrayList<Integer>(Arrays.asList(14, 70, 200, 550, 750, 950)), 100, 0, "orange"));
		setPlace(18, new PlaceLand("Boulevard Saint-Victorien", 180, new ArrayList<Integer>(Arrays.asList(14, 70, 200, 550, 750, 950)), 100, 0, "orange"));
		setPlace(19, new PlaceLand("Place Pigalle", 200, new ArrayList<Integer>(Arrays.asList(16, 80, 220, 600, 800, 1000)), 100, 0, "orange"));

		setPlace(21, new PlaceLand("Avenue Matignon", 220, new ArrayList<Integer>(Arrays.asList(18, 90, 250, 700, 875, 1050)), 150, 0, "red"));
		setPlace(23, new PlaceLand("Boulevard Malesherbes", 220, new ArrayList<Integer>(Arrays.asList(18, 90, 250, 700, 875, 1050)), 150, 0, "red"));
		setPlace(24, new PlaceLand("Avenue Henri-Martin", 240, new ArrayList<Integer>(Arrays.asList(20, 100, 300, 750, 925, 1100)), 150, 0, "red"));

		setPlace(26, new PlaceLand("Faubourg Saint-Honoré", 260, new ArrayList<Integer>(Arrays.asList(22, 110, 330, 800, 975, 1150)), 150, 0, "yellow"));
		setPlace(27, new PlaceLand("Place de la Bourse", 260, new ArrayList<Integer>(Arrays.asList(22, 110, 330, 800, 975, 1150)), 150, 0, "yellow"));
		setPlace(29, new PlaceLand("Rue La Fayette", 280, new ArrayList<Integer>(Arrays.asList(24, 120, 360, 850, 1025, 1200)), 150, 0, "yellow"));

		setPlace(31, new PlaceLand("Avenue de Breuteuil", 300, new ArrayList<Integer>(Arrays.asList(26, 130, 390, 900, 1100, 1275)), 200, 0, "green"));
		setPlace(32, new PlaceLand("Avenue Foch", 300, new ArrayList<Integer>(Arrays.asList(26, 130, 390, 900, 1100, 1275)), 200, 0, "green"));
		setPlace(34, new PlaceLand("Boulevard des Capucines", 320, new ArrayList<Integer>(Arrays.asList(28, 150, 450, 1000, 1200, 1400)), 200, 0, "green"));

		setPlace(37, new PlaceLand("Avenue des Champs-Élysées", 350, new ArrayList<Integer>(Arrays.asList(35, 175, 500, 1100, 1300, 1500)), 200, 0, "blue"));
		setPlace(39, new PlaceLand("Rue de la Paix", 400, new ArrayList<Integer>(Arrays.asList(50, 200, 600, 1400, 1700, 2000)), 200, 0, "blue"));
		
		/* INITIALISATION DES CARTES CHANCES */
		chance.add(new CardPayMoney("Amende", "Amende pour excés de vitesse : 15 euros.", 15));
		chance.add(new CardPayMoney("Président du conseil d'administration", "Vous avez été élu président du conseil d'administration. \nVersez 50 euros à chaque joueur.", 50));
		

		chance.add(new CardReceiveMoney("Versement", "La banque vous verse un dividende de 50 euros.", 50));
		chance.add(new CardReceiveMoney("Gain", "Vos terrains vous rapportent. Touchez 150 euros.", 150));
		chance.add(new CardReceiveMoney("Mots croisés", "Vous avez gagné le prix de mots-croisés ! \nRecevez 100 euros.", 100));


	


		chance.add(new CardMove("Case Départ", "Avancez jusqu'á la case départ. \n(Recevez 200 euros)", 0, false));
		chance.add(new CardMove("Rue de la Paix", "Rendez-vous Rue de la Paix.", 39, false));
		chance.add(new CardMove("Henri-Martin", "Rendez-vous à l'Avenue Henri-Martin. \nSi vous passez par la case départ, recevez 200 euros.", 24, false));
		chance.add(new CardMove("Boulevard de la Villette", "Avancez au Boulevard de la Vilette. \nSi vous passez par la case départ, recevez 200 euros.", 11, false));
		chance.add(new CardMove("Gare de Lyon", "Avancez à la gare de Lyon. \nSi vous passez par la case départ, recevez 200 euros.", 15, false));
		chance.add(new CardMove("Reculez", "Reculez de 3 cases.", -3, true));
		chance.add(new CardMove("Nv Depart", "Le joueur déménage et prend un \nnouveau départ au Technopole.", 0, false));

	
		
		chance.add(new CardMove("Prison", "Allez en prison. \nAvancez tout droit en prison. \nNe passez pas par la case départ, ne recevez pas 200 euros.", 10, false));
		chance.add(new CardLeavePrison("Sortie", "Vous êtes libéré de prison. \n(Cette carte doit être conservée)"));
		
		Collections.shuffle(chance); 


		
		community.add(new CardPayMoney("Frais de scolarité", "Payez 150 euros de frais de scolarité.", 150));
		community.add(new CardPayMoney("Frais d'hospitalisation", "Payez 100 euros de frais d'hospitalisation.", 100));
		community.add(new CardPayMoney("Médecin", "Visite chez le médecin : payez 50 euros.", 50));

		community.add(new CardReceiveMoney("Remboursement", "Les impéts vous remboursent 20 euros.", 20));
		community.add(new CardReceiveMoney("Assurance vie", "Votre assurance vie vous rapporte 100 euros.", 100));
		community.add(new CardReceiveMoney("Anniversaire", "C'est votre anniversaire ! \nChaque joueur doit vous donner 10 euros.", 10));
		community.add(new CardReceiveMoney("Commission d'expert", "Commission d'expert immobilier. \nRecevez 25 euros.", 25));
		community.add(new CardReceiveMoney("Prix de beauté", "Vous avez gagné le deuxiéme prix de beauté. \nRecevez 10 euros.", 10));
		community.add(new CardReceiveMoney("Stock", "La vente de votre stock vous rapporte 50 euros.", 50));
		community.add(new CardReceiveMoney("Héritage", "Vous héritez de 100 euros.", 100));
		community.add(new CardReceiveMoney("Placement", "Votre placement vous rapporte. \nRecevez 100 euros.", 100));
		community.add(new CardReceiveMoney("Erreur de la Banque", "Erreur de la Banque en votre faveur. \nRecevez 200 euros.", 200));

		community.add(new CardMove("Prison", "Allez en prison. \nAvancez tout droit en prison. \nNe passez pas par la case départ, ne recevez pas 200 euros.", 10, false));
		community.add(new CardLeavePrison("Sortie", "Vous étes libéré de prison. \n(Cette carte doit étre conservée)"));

		Collections.shuffle(community); 
	}

	
	 
	public void movePlayer(MonopolyPlayer player, int numberOfPlaces) {
		int pos;

		if((player.getPosition() + numberOfPlaces) >= getNbPlaces()) {
			pos = (player.getPosition() + numberOfPlaces) % getNbPlaces();
			System.out.println(" > " + player.getName() + " passes through place Departure and wins 200 euros !");
			player.addMoney(200);
		}
		else
			pos = player.getPosition() + numberOfPlaces;

		if(!player.getIsBankrupt()) {
			player.setPosition(pos);
		}
	}

	
	public MonopolyPlayer getActivePlayer() {
		return this.players.get(getActivePlayerID());
	}

	
	public MonopolyPlayer getPlayer(int i) {
		return this.players.get(i);
	}

	
	@Override
	public Player isWinner() {
		int res = 0;
		for(int i=0; i<players.size(); i++) {
			if(getPlayer(i).getMoney() > getPlayer(res).getMoney())
				res = i;
		}
		return getPlayer(res);
	}

	
	public Place getPlaceActive() {
		return getPlace(getActivePlayer().getPosition());
	}


	@Override
	public boolean endOfGame() {
		int nbPlayersInGame = 0;
		for(MonopolyPlayer j:players) {
			if(!j.getIsBankrupt()) nbPlayersInGame++;
		}
		return (nbPlayersInGame <= 1);
	}

	
	public Card takeCardChance() {
		Card c = chance.remove(0);
		if(!c.getName().equals("Sortie"))
			chance.add(c);
		return c;
	}

	
	public Card takeCardCommunity() {
		Card c = community.remove(0);
		if(!c.getName().equals("Sortie"))
			community.add(c);
		return c;
	}

	
	public void putCardLeavePrisonIntoDeck() {

		boolean cardInDeckChance = false;
		for(Card c:chance) {
			if(c.getName().equals("Sortie"))
				cardInDeckChance = true;  
		}

		if(cardInDeckChance)
			chance.add(new CardLeavePrison("Sortie", "Vous étes libéré de prison. \n(Cette carte doit étre conservée)"));
		else
			community.add(new CardLeavePrison("Sortie", "Vous étes libéré de prison. \n(Cette carte doit étre conservée)"));
	}


	

	@Override
	public String toString() {
		return "PlateauMonopoly [toString()=" + super.getPlace(1) + "]";
	}
	
	public int getHousesLeft() {
		return housesLeft;
	}
	
	public void demolishHouse(int n) {
		housesLeft+=n;
	}
	
	public int getHotelsLeft() {
		return hotelsLeft;
	}
	public void demolishHotels(int n) {
		hotelsLeft+=n;
	}
}