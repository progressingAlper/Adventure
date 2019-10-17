package RollPlayAdventure;

import java.util.ArrayList;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

public class Spieler {

	ArrayList<Items> items = new ArrayList<Items>();
	ArrayList<Waffen> waffen = new ArrayList<Waffen>();
	ArrayList<Potions> potions = new ArrayList<Potions>();
	private int wertsteigerung;
	private int hp;
	private int schaden1;
	private final int rüstung;
	private String name;
	private Waffen aktuelleWaffe;
	private Waffen gegnerWaffe;
	private static Scanner eingabe;


	
	//ADD list
	
	
	public static void usePotion() {
		
	}
	
	public void addItem(Items i) {
		this.items.add(i);

	}

	public void addWaffe(Waffen w) {
		this.waffen.add(w);
		this.items.add(w);
	}
	
	public void addPotion(Potions p) {
		this.items.add(p);
		this.potions.add(p);
	}


	public Spieler(int hp, int schaden1, int d, int rüstung, String name) {

		this.hp = hp;
		this.schaden1 = schaden1;
		this.name = name;
		this.wertsteigerung = d;
		this.rüstung = rüstung;

	}

	public void gotHit1(int gegnerDmg1, int rüstung) {
		int schaden = gegnerDmg1 - rüstung;
		
		this.hp -= schaden;
	}

	public void hit(int gegnerDmg2, Spieler feind) {
		this.hp -= gegnerDmg2;
	}

	// KAMPFSYSTEm

	public boolean kampf(Spieler feind, Waffen meineWaffe, Waffen gegnerWaffe) {

		boolean a = false;

		eingabe = new Scanner(System.in);
		// Wenn gewonnen dann true!
		int  random;

		while (this.hp > 0) {
			int z = (int) (Math.random() * 100 + 1);
			random = (int) (Math.random() * 100 + 1);
			int zRate = (int)(Math.random()*5+1);

			
			System.out.println("du greifst an");
			System.out.println("rate eine Zahl zwischen 1 und 5 um einen eventuel einen Kritischen treffer zu erzielen");
			 System.out.println(zRate);
			int rate = eingabe.nextInt();
			if (z <= meineWaffe.warscheinlichkeit && zRate != rate) {

				System.out.println("Treffer!");
				feind.gotHit1(meineWaffe.schaden, this.rüstung);

			}else if (rate == zRate && z <= meineWaffe.warscheinlichkeit) {
				System.out.println("RICHTIG!");
				System.out.print("Kritischer Treffer ");
				feind.gotHit1(meineWaffe.schaden, this.rüstung);
				feind.gotHit1(meineWaffe.schaden, this.rüstung);

			} else if (z > meineWaffe.warscheinlichkeit) {
				System.out.println("leider verfehlehlt!");
			}

			System.out.println("Dein gegner hat jetzt: " + feind.getHp() + " hp ");
			System.out.println("Du hast " + this.hp + " hp");

			if (feind.getHp() <= 0) {
				System.out.println("du hast GEWONNEN!!!!");
				a = true;
				return true;

			} else if (getHp() <= 0) {
				a = false;
				return false;

			}

			System.out.println("der gegner Greift an!! ");

			if (random <= gegnerWaffe.warscheinlichkeit) {

				gotHit1(gegnerWaffe.schaden, feind.rüstung );

			} else if (random <= gegnerWaffe.crit) {
				System.out.println("Kritischer Treffer! Doppelter Schaden");
				gotHit1(gegnerWaffe.schaden, feind.rüstung);
				gotHit1(gegnerWaffe.schaden, feind.rüstung);

			} else if (random > gegnerWaffe.warscheinlichkeit) {
				System.out.println("Der gegner hat verfehlehlt!");

			}

			if (feind.getHp() <= 0) {
				System.out.println("du hast GEWONNEN!!!!");
				a = true;
				return true;

			} else if (getHp() <= 0) {
				a = false;
				return false;

			}

		}
		return a;

	}

	
	
	
	
	// getter
	public int getHp() {
		return this.hp;
	}

	public int getSchaden1() {
		return this.schaden1;
	}

	

	public String getName() {
		return this.name;
	}

	public int getWertsteigerung() {
		return this.wertsteigerung;
	}

	public Waffen getAktuelleWaffe() {
		
		return aktuelleWaffe;
	}

	// Setter

	public  void setWaffe(int i) {

		
		aktuelleWaffe = waffen.get(i);
		}

	
	
	
	
	
	
	
	public void Inventar() {
		System.out.println("INVENTAR:");
		System.out.println("");
		int i = 1;
		for (int j = 0; j < items.size(); j++, i++) {
			System.out.println(i +". " +this.items.get(j).name);
		}
		
	
	}
		public void Waffenslots() {
			System.out.println("Waffen:");
			System.out.println("");
			int i = 1;
			for (int j = 0; j < waffen.size(); j++, i++) {
				System.out.println(i+  " ." +this.waffen.get(j).name);
			}
	
			
		}
		public  void waffenauswahl() {
			eingabe = new Scanner(System.in);
			int auswahl;
			boolean wiederholen;
			Waffenslots();
			do {
				System.out.println("Wähle deine Waffe aus");
				auswahl = eingabe.nextInt();
				auswahl--;

				if (auswahl >= waffen.size()) {
					System.out.println("Ungültige eingabe! ");
					wiederholen = true;
				} else {
					wiederholen = false;
				}
			} while (wiederholen);
			setWaffe(auswahl);
			System.out.println("du hast: " + waffen.get(auswahl).name + " gewählt");
		
		}
}
