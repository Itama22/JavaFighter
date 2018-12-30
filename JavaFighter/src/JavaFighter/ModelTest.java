package JavaFighter;

import java.util.Timer;

import org.junit.jupiter.api.Test;

class ModelTest {

	@Test
	void test() {

		Model javaFighter = new Model();
		javaFighter.visualisieren();

		int damageNormal = 1;
		int damageKonter = 2;
		boolean nani = false;
		boolean gewonnen = false;

		// Damage, Lebensbalken & Fail testen

		javaFighter.damageMachen(damageNormal);
		javaFighter.damageMachen(damageNormal);
		javaFighter.damageMachen(damageNormal);
		javaFighter.damageMachen(damageNormal);
		javaFighter.damageMachen(damageNormal);
		javaFighter.damageMachen(damageNormal);
		javaFighter.damageMachen(damageNormal);
		javaFighter.damageMachen(damageNormal);
		javaFighter.damageMachen(damageNormal);
		boolean versagt = javaFighter.noob();
		System.out.println(versagt);
		javaFighter.damageMachen(damageKonter);
		javaFighter.visualisieren();
		versagt = javaFighter.noob();
		System.out.println(versagt);

		// FOKUS & WIN testen

		javaFighter.fokusErlangen(damageNormal);
		javaFighter.fokusErlangen(damageNormal);
		javaFighter.fokusErlangen(damageNormal);
		javaFighter.fokusErlangen(damageNormal);
		javaFighter.fokusErlangen(damageNormal);
		javaFighter.fokusErlangen(damageNormal);
		javaFighter.fokusErlangen(damageNormal);
		javaFighter.fokusErlangen(damageNormal);
		javaFighter.fokusErlangen(damageNormal);
		nani = javaFighter.naniMethode();
		javaFighter.gewinnErmitteln();
		System.out.println(nani);
		javaFighter.fokusErlangen(damageNormal);
		javaFighter.visualisieren();
		nani = javaFighter.naniMethode();
		System.out.println(nani);
		javaFighter.gewinnErmitteln();

	}
}
