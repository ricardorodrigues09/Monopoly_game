package boardgame;


/*
 * Abstract class
 * defines the name, position and id of the player
 * */
public abstract class Player {

	public String name;
	private int id;
	private int position = 0;


	public Player(String name, int id) {
		setName(name);
		setID(id);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		if(name == null || name.isEmpty())
			throw new IllegalArgumentException("The name can not be empty or null");
		this.name = name;
	}
	
	public int getID() {
		return this.id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public int getPosition() {
		return this.position;
	}

	public void setPosition(int pos) {
		this.position = pos;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", id=" + id + ", position=" + position + "]";
	}

}
