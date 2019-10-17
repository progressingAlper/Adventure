package RollPlayAdventure;

public class Potions extends Items {
int heal;
int effekt;
int anzahl;

	
public Potions(String name, int effekt, int anzahl) {
		
		super(name);
		this.effekt = effekt;
		this.anzahl = anzahl;
		
		
	}
}
