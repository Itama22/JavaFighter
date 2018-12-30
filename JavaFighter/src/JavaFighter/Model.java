package JavaFighter;

import java.util.Random;

import java.io.*;
import sun.audio.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Model {

	int fokusValue = 10;
	int lebensbalkenValue = 10;
	public int damageNormal = 1;
	public int damageKonter = 2;
	public int damageFokus = 2;
	public boolean konter = false;
	public boolean blocken = false;
	public boolean nani = false;
	public boolean finisher = false;
	public boolean gewonnen = false;
	private char[] lebensbalken = null;
	private char[] fokusbalken = null;
	static Timer ki = new Timer();
	static boolean done = false;

	// Konstruktor

	public Model() {

		lebensbalken = new char[lebensbalkenValue];

		for (int i = 0; i < lebensbalkenValue; i++) {
			lebensbalken[i] = ' ';
		}

		fokusbalken = new char[fokusValue];

		for (int i = 0; i < fokusValue; i++) {
			fokusbalken[i] = ' ';
		}
	}

	// Methoden

	// Balken-Getter

	public char[] getLebensbalken() {
		return lebensbalken;
	}

	public char[] getFokus() {
		return fokusbalken;
	}

	// Blocken-Methode & Timer

	public void blockenMethode() {
		Timer blockentimer = new Timer();
		blocken = true;
		try {

			AudioInputStream parry = AudioSystem.getAudioInputStream(
					new File("C:\\Users\\Manue\\Desktop\\Studium\\Programmieren\\BeatYourEnemy\\Parry.wav"));

			Clip clip = AudioSystem.getClip();
			clip.open(parry);
			clip.start();
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
		//System.out.println("Blocken ON");

		TimerTask blockentask = new TimerTask() {
			public void run() {
				blocken = false;
				//System.out.println("Blocken OFF");
				blockentimer.cancel();
			}
		};

		blockentimer.schedule(blockentask, 1000);
	}

	// KI-Methode

	public void KI() {

		long interval = 0;

		gewinnErmitteln();
		boolean verloren = noob();
		int start = 0;
		int zaehler = 0;

		while (gewonnen == false && verloren == false) {
			try {
				Random r = new Random();
				double randomValue = 1 + (3 - 1) * r.nextDouble();

				ki = new Timer();
				interval = (long) (randomValue * 1000);

				TimerTask kitask = new TimerTask() {
					public void run() {
						damageMachen(damageNormal);
						// Visualisieren TESTEN
						visualisieren();
						done = true;
						ki.cancel();
					}
				};
				if (start == zaehler) {
					ki.schedule(kitask, interval);
					zaehler++;
				} else if (done == true) {
					done = false;
					ki.schedule(kitask, interval);
				}

				gewinnErmitteln();
				verloren = noob();

			} catch (IllegalStateException e) {
				System.out.println("EXCEPTION: " + e);
			}
			continue;
		}
		if (verloren == true) {
			System.out.println("lol noob");
			ki.cancel();
			try {

				AudioInputStream sad = AudioSystem.getAudioInputStream(
						new File("C:\\Users\\Manue\\Desktop\\Studium\\Programmieren\\BeatYourEnemy\\SadVioline.wav"));

				Clip clip = AudioSystem.getClip();
				clip.open(sad);
				clip.start();
			} catch (Exception ex) {
				System.out.println("Error with playing sound.");
				ex.printStackTrace();
			}
		}
	}

	// Damage-Methoden

	public void damageMachen(int damage) {
		int damagedone = 0;
		int thisdamage = damage;
		int focusdamage = 2;
		int focusdamagedone = 0;

		if (blocken == false) {

			// AUDIO

			for (int i = 0; i < lebensbalkenValue; i++) {
				if (thisdamage != damagedone && lebensbalken[i] == ' ') {
					lebensbalken[i] = 'I';
					damagedone++;
					try {

						AudioInputStream punch = AudioSystem.getAudioInputStream(new File(
								"C:\\Users\\Manue\\Desktop\\Studium\\Programmieren\\BeatYourEnemy\\PunchSoundEffect.wav"));

						Clip clip = AudioSystem.getClip();
						clip.open(punch);
						clip.start();
					} catch (Exception ex) {
						System.out.println("Error with playing sound.");
						ex.printStackTrace();
					}
				}
			}
			for (int i = fokusValue - 1; i >= 0; i--) {
				if (focusdamage != focusdamagedone && fokusbalken[i] == 'I') {
					fokusbalken[i] = ' ';
					focusdamagedone++;
					try {

						AudioInputStream punch = AudioSystem.getAudioInputStream(new File(
								"C:\\Users\\Manue\\Desktop\\Studium\\Programmieren\\BeatYourEnemy\\PunchSoundEffect.wav"));

						Clip clip = AudioSystem.getClip();
						clip.open(punch);
						clip.start();
					} catch (Exception ex) {
						System.out.println("Error with playing sound.");
						ex.printStackTrace();
					}
				}
			}
		} else {
			int focusdone = 0;
			int thisfocus = 1;
			for (int i = 0; i < fokusValue; i++) {
				if (thisfocus != focusdone && fokusbalken[i] == ' ') {
					fokusbalken[i] = 'I';
					focusdone++;
					// BLOCKEN SOUND
				}
			}
		}
	}

	public void fokusErlangen(int fokus) {
		int focusdone = 0;
		int thisfocus = fokus;
		blocken = false;
		for (int i = 0; i < fokusValue; i++) {
			if (thisfocus != focusdone && fokusbalken[i] == ' ') {
				fokusbalken[i] = 'I';
				focusdone++;
				boolean nani = naniMethode();
				try {

					AudioInputStream punch = AudioSystem.getAudioInputStream(new File(
							"C:\\Users\\Manue\\Desktop\\Studium\\Programmieren\\BeatYourEnemy\\PunchSoundEffect.wav"));

					Clip clip = AudioSystem.getClip();
					clip.open(punch);
					clip.start();
				} catch (Exception ex) {
					System.out.println("Error with playing sound.");
					ex.printStackTrace();
				}
			}
		}
	}

	public boolean naniMethode() {
		int laenge = fokusbalken.length - 1;

		if (fokusbalken[laenge] == 'I') {
			nani = true;
		} else {
			nani = false;
		}
		return nani;
	}

	// Gewinn-Methode
	public void gewinnErmitteln() {
		gewonnen = false;
		boolean nani = naniMethode();

		if (nani == true) {
			gewonnen = true;
			try {

				AudioInputStream omaewa = AudioSystem.getAudioInputStream(
						new File("C:\\Users\\Manue\\Desktop\\Studium\\Programmieren\\BeatYourEnemy\\OmaeWa.wav"));

				Clip clip = AudioSystem.getClip();
				clip.open(omaewa);
				clip.start();
			} catch (Exception ex) {
				System.out.println("Error with playing sound.");
				ex.printStackTrace();
			}
		}
	}

	// Failure-Methode
	public boolean noob() {
		boolean fail = false;
		int summe = 0;
		for (int i = 0; i < lebensbalkenValue; i++) {
			if (lebensbalken[i] == 'I') {
				summe++;
			}
		}

		if (summe == lebensbalkenValue) {
			fail = true;
		}

		return fail;
	}

	// Visuaisieren

	public void visualisieren() {
		System.out.println("------FOKUS-----------");
		System.out.println("|" + fokusbalken[0] + "|" + fokusbalken[1] + "|" + fokusbalken[2] + "|" + fokusbalken[3]
				+ "|" + fokusbalken[4] + "|" + fokusbalken[5] + "|" + fokusbalken[6] + "|" + fokusbalken[7] + "|"
				+ fokusbalken[8] + "|" + fokusbalken[9] + "|");
		System.out.println("----------------------");
		System.out.println("-----LEBEN------------");
		System.out.println("|" + lebensbalken[0] + "|" + lebensbalken[1] + "|" + lebensbalken[2] + "|" + lebensbalken[3]
				+ "|" + lebensbalken[4] + "|" + lebensbalken[5] + "|" + lebensbalken[6] + "|" + lebensbalken[7] + "|"
				+ lebensbalken[8] + "|" + lebensbalken[9] + "|");
		System.out.println("----------------------");
	}
}
