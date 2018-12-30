package JavaFighter;

public class MainTest {

	public static void main(String[] args) {

		Model javaFighter = new Model();
		javaFighter.visualisieren();
		int damageNormal = 1;

		// Fokus und Blocken testen (musste in main getestet werden, da Timer in JUnit
		// nicht richtig funktioniert!)
		/*
		 * javaFighter.fokusErlangen(damageNormal);
		 * javaFighter.fokusErlangen(damageNormal); javaFighter.visualisieren();
		 * javaFighter.damageMachen(damageNormal); javaFighter.visualisieren();
		 * javaFighter.fokusErlangen(damageNormal);
		 * javaFighter.fokusErlangen(damageNormal); javaFighter.blockenMethode();
		 * javaFighter.damageMachen(damageNormal); javaFighter.visualisieren();
		 */

		// KI testen

		// javaFighter.KI();

		// Gewinn Testen

		/*
		 * boolean nani = false; boolean gewonnen = false;
		 * 
		 * javaFighter.fokusErlangen(damageNormal);
		 * javaFighter.fokusErlangen(damageNormal);
		 * javaFighter.fokusErlangen(damageNormal);
		 * javaFighter.fokusErlangen(damageNormal);
		 * javaFighter.fokusErlangen(damageNormal);
		 * javaFighter.fokusErlangen(damageNormal);
		 * javaFighter.fokusErlangen(damageNormal);
		 * javaFighter.fokusErlangen(damageNormal);
		 * javaFighter.fokusErlangen(damageNormal);
		 * javaFighter.fokusErlangen(damageNormal); javaFighter.gewinnErmitteln();
		 */

		javaFighter.blockenMethode();
	}

}
