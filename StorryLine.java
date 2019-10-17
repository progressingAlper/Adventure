package RollPlayAdventure;

import java.util.Scanner;

public class StorryLine {

	private static Scanner eingabe;

	public static void main(String[] args) {
		eingabe = new Scanner(System.in);

		String inp;
		boolean ausnahme = false;

		Spieler magier = new Spieler(1000, 120, 8, 0, "Du");
		Spieler soldat = new Spieler(100, 20, 5, 20, "Soldat");

		Waffen schwert = new Waffen("Schwert", 25, 67, 30);
		Waffen dolch = new Waffen("Dolch", 15, 70, 34);

		Potions heal = new Potions("heal potion", 20, 0);

		magier.addWaffe(dolch);
		magier.addWaffe(schwert);
		magier.addItem(heal);

		magier.Waffenslots();

		System.out.println(
				"Hier eine liste aller Befehle! [hp] = lebenanzeigen, [i] = inventar �ffnen, [w] = Waffe ausw�hlen [name der Waffe] um die Werte zu sehen!");

		System.out.println(
				"Deine Geschichte! Du bist der Sohn eines besorgten K�nigs! Dein ganzes Leben lang hast du die Welt au�erhalb der Mauern deines");
		System.out.println(
				"K�nigreiches nicht gesehen! Eines Tages taucht aus dem nichts eine Arme von dem feindliche K�nigreich auf und nehmen das K�nigreich");
		System.out.println(
				"ein! Du schaffst es gerade so zu fliehen! Du rennst in den Verfluchten Wald! Trotz des Angriffes konntest du noch einen Dolch, und");
		System.out.println("heiltr�nke mitnehmen! ");

		magier.addItem(dolch);

		System.out.println(
				"Du schleichst weiter in den Wald und siehst einen Nachz�gler Soldaten m�chtest du ihn aus dem Hinterhalt angreifen[y/n]");

		do {

			inp = eingabe.next();
			if (inp.equals("w") || inp.equals("W")) {
				magier.Waffenslots();

				magier.waffenauswahl();

								ausnahme = true;
			} else if (inp.equals("i") || inp.equals("I")) {
				magier.Inventar();
				ausnahme = true;

				// Aus dem hinterhalt angreifen
			} else if (inp.equals("y")) {
				int z = (int) (Math.random() * 100 + 1);
				ausnahme = false;
				if (z <= 15) {
					System.out.println("Du bist auf einen Ast getreten! der Soldat hat dich bemertk");

					if (!magier.kampf(soldat, dolch, schwert)) {

						System.out.println("Game Over!");
						System.exit(0);
					}
					
					System.out.println("+ 1 Schwert!");
					magier.addItem(schwert);
				} else if (z > 15) {

					System.out.println(
							"du bist direckt hinter dem Soldaten und schaltest ihn aus! er l�sst ein schwert fallen!");
					System.out.println("+ 1 Schwert!");
					magier.addItem(schwert);

				}
			} else if (inp.equals("n")) {
				ausnahme = false;

			} else if (inp.equals("hp")) {
				System.out.println("du hast " + magier.getHp() + " HP");
				ausnahme = true;
			} else {
				System.out.println("falsche eingabe! Bitte nochmal eingeben!");
				ausnahme = true;
			}
		} while (ausnahme);

		
		//Nachdem der Soldat von hinten get�tet wurde
		if (inp.equals("y")) {
			
			
			
			//Nachdem ich den Soldaten vorbeilaufen lasse
		} else if (inp.equals("n")) {
			int z = (int) (Math.random() * 100 + 1);
			System.out.println(
					"Du hast gewartet, und dem Fluss entlang in richtung eines H�gels um ein besseren �berblick zu haben! Es wird langsam nacht");
			System.out.println(
					"Es wird langsam Dunkel und du sucht einen Platz wo du schlafen kannst findest einen Halbhohen bauen und eine H�hle wo m�chtest du dein Lager aufbauen? [h/b]");
			int j = (int) (Math.random() * 30 + 10);
			
			
			do {

				inp = eingabe.next();
				if (inp.equals("w") || inp.equals("W")) {
					magier.Waffenslots();

					magier.waffenauswahl();

					ausnahme = true;
				} else if (inp.equals("i") || inp.equals("I")) {
					magier.Inventar();
					ausnahme = true;

			
			// Baum kletter
				}else if(inp.equals("hp")) {
					System.out.println("du hast " + magier.getHp() + " HP");
					ausnahme = true;
					
				}else if (inp.equals("b")) {
				System.out.println("Du kletterst auf den baum!");
				// Runterfallen zu 18&
				if (z <= 18) {
					System.out.println(
							"Du stehst auf einem Ast! Aufeinmal bricht er unter deinen F��en ab! du f�llst runter");
					System.out.println("Du bekommst " + j + " Schaden!");
					magier.gotHit1(j, 0);
					System.out.println("du kl�tterst trotzdem wieder hoch!");

				}

				
				
				System.out.println("Du kletterst auf einen extrem breiten Ast legst Moos drauf und schl�fst!");
				// Storry weiterf�hren
				
				System.out.println("Am n�chsten morgen wachst du auf und bemerkst das unter die eine Gruppe Soldaten entlang l�uft, du versucht ganz leise zu bleiben dass dich die Soldaten nicht entdecken. ");
						System.out.println("Als sie schon ein ganzes st�ck vorbei gelaufen sind Kletterst du den Baum herunter und folgst ihnen. Doch du bist unvorsichtig und tritst auf einen Stock");
						System.out.println("Einer der Soldaten h�rt das brechen des Stockes und schaut nach woher das ger�uch kam. Dir bleibt nichts �berig au?er gegen ihn zu K�mpfen");
						magier.waffenauswahl();
						if (!magier.kampf(soldat, magier.getAktuelleWaffe(), schwert)) {

							System.out.println("Game Over!");
							System.exit(0);
						}				
						
						
			
			
			
			
			
			
			
			
			// in die H�hle gehen
			} else if (inp.equals("h")) {
			
			} else {
				System.out.println("falsche eingabe! Bitte nochmal eingeben!");
				ausnahme = true;
			}
			
			
			
			
			

		}while(ausnahme);

	}
	}
}
