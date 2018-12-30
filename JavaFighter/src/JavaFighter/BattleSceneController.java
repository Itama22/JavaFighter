package JavaFighter;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import JavaFighter.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class BattleSceneController implements Initializable {

	@FXML
	private String thisCharacter1 = "";
	@FXML
	private String thisCharacter2 = "";
	@FXML
	private boolean start = false;
	@FXML
	private AnchorPane anchorBattle;
	@FXML
	private ImageView wizard1;
	@FXML
	private ImageView wizard2;
	@FXML
	private ImageView president1;
	@FXML
	private ImageView president2;
	@FXML
	private ImageView waluigi1;
	@FXML
	private ImageView waluigi2;
	@FXML
	private ImageView wombat1;
	@FXML
	private ImageView wombat2;
	@FXML
	private Button attack;
	@FXML
	private Button block;
	@FXML
	private Button finish;
	@FXML
	private ImageView blockImage;
	@FXML
	private ImageView damage;
	@FXML
	private ImageView focus;
	@FXML
	private ImageView eyeLeft;
	@FXML
	private ImageView eyeRight;
	@FXML
	private ImageView failScreen;
	@FXML
	private Pane focusPaneZelle0;
	@FXML
	private Pane focusPaneZelle1;
	@FXML
	private Pane focusPaneZelle2;
	@FXML
	private Pane focusPaneZelle3;
	@FXML
	private Pane focusPaneZelle4;
	@FXML
	private Pane focusPaneZelle5;
	@FXML
	private Pane focusPaneZelle6;
	@FXML
	private Pane focusPaneZelle7;
	@FXML
	private Pane focusPaneZelle8;
	@FXML
	private Pane focusPaneZelle9;
	@FXML
	private Pane damagePaneZelle0;
	@FXML
	private Pane damagePaneZelle1;
	@FXML
	private Pane damagePaneZelle2;
	@FXML
	private Pane damagePaneZelle3;
	@FXML
	private Pane damagePaneZelle4;
	@FXML
	private Pane damagePaneZelle5;
	@FXML
	private Pane damagePaneZelle6;
	@FXML
	private Pane damagePaneZelle7;
	@FXML
	private Pane damagePaneZelle8;
	@FXML
	private Pane damagePaneZelle9;
	@FXML
	Clip battleTheme;
	@FXML
	ImageView winner;
	@FXML
	ImageView youDied;
	@FXML
	ImageView explosion;
	@FXML
	ImageView eyes;
	@FXML
	ImageView crater;

	@FXML
	private char[] lebensbalken = null;
	@FXML
	private char[] fokusbalken = null;

	private Model javaFighter = null;

	public int damageNormal = 1;
	public boolean nani = false;
	public boolean gewonnen = false;
	public boolean blocken = false;
	
	Timer ki = new Timer();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		javaFighter = new Model();

		lebensbalken = javaFighter.getLebensbalken();
		fokusbalken = javaFighter.getFokus();

		enemyAttack();

		// TODO irgendwie die Balken importieren um si zu usen.

		try {

			AudioInputStream ninja = AudioSystem.getAudioInputStream(
					new File("C:\\Users\\Manue\\Desktop\\Studium\\Programmieren\\BeatYourEnemy\\NinjaGaiden.wav"));

			battleTheme = AudioSystem.getClip();
			battleTheme.open(ninja);
			battleTheme.start();
			start = true;

		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
		try {

			AudioInputStream ninja = AudioSystem.getAudioInputStream(
					new File("C:\\Users\\Manue\\Desktop\\Studium\\Programmieren\\BeatYourEnemy\\Fresse.wav"));

			Clip battleTheme = AudioSystem.getClip();
			battleTheme.open(ninja);
			battleTheme.start();
			start = true;

		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}

		Timer picsTimer = new Timer();

		TimerTask picsAppear = new TimerTask() {
			public void run() {

				if (thisCharacter1.equals("wizard"))

				{
					wizard1.setVisible(true);
				} else if (thisCharacter1.equals("president")) {
					president1.setVisible(true);
				} else if (thisCharacter1.equals("waluigi")) {
					waluigi1.setVisible(true);
				} else if (thisCharacter1.equals("wombat")) {
					wombat1.setVisible(true);
				}

				if (thisCharacter2.equals("wizard")) {
					wizard2.setVisible(true);
				} else if (thisCharacter2.equals("president")) {
					president2.setVisible(true);
				} else if (thisCharacter2.equals("waluigi")) {
					waluigi2.setVisible(true);
				} else if (thisCharacter2.equals("wombat")) {
					wombat2.setVisible(true);
				}
			}
		};

		picsTimer.schedule(picsAppear, 100);

	}

	// METHODEN

	public void BalkenAktualisieren() {
		int fokusvalue = fokusbalken.length;
		int lebensvalue = lebensbalken.length;
		for (int i = 0; i < fokusvalue; i++) {

			fokusbalken = javaFighter.getFokus();
			Pane fokusZelle = null;

			if (i == 0) {
				fokusZelle = focusPaneZelle0;
			} else if (i == 1) {
				fokusZelle = focusPaneZelle1;
			} else if (i == 2) {
				fokusZelle = focusPaneZelle2;
			} else if (i == 3) {
				fokusZelle = focusPaneZelle3;
			} else if (i == 4) {
				fokusZelle = focusPaneZelle4;
			} else if (i == 5) {
				fokusZelle = focusPaneZelle5;
			} else if (i == 6) {
				fokusZelle = focusPaneZelle6;
			} else if (i == 7) {
				fokusZelle = focusPaneZelle7;
			} else if (i == 8) {
				fokusZelle = focusPaneZelle8;
			} else if (i == 9) {
				fokusZelle = focusPaneZelle9;
			}

			if (fokusbalken[i] == ' ') {
				fokusZelle.setVisible(false);
			} else if (fokusbalken[i] == 'I') {
				fokusZelle.setVisible(true);
			}
		}

		for (int i = 0; i < lebensvalue; i++) {

			fokusbalken = javaFighter.getFokus();
			Pane damageZelle = null;

			if (i == 0) {
				damageZelle = damagePaneZelle0;
			} else if (i == 1) {
				damageZelle = damagePaneZelle1;
			} else if (i == 2) {
				damageZelle = damagePaneZelle2;
			} else if (i == 3) {
				damageZelle = damagePaneZelle3;
			} else if (i == 4) {
				damageZelle = damagePaneZelle4;
			} else if (i == 5) {
				damageZelle = damagePaneZelle5;
			} else if (i == 6) {
				damageZelle = damagePaneZelle6;
			} else if (i == 7) {
				damageZelle = damagePaneZelle7;
			} else if (i == 8) {
				damageZelle = damagePaneZelle8;
			} else if (i == 9) {
				damageZelle = damagePaneZelle9;
			}

			if (lebensbalken[i] == ' ') {
				damageZelle.setVisible(false);
			} else if (lebensbalken[i] == 'I') {
				damageZelle.setVisible(true);
			}
		}

	}

	public void Character1(String character1) {
		thisCharacter1 = character1;

	}

	public void Character2(String character2) {
		thisCharacter2 = character2;
	}

	public void Attack(ActionEvent event) throws IOException {

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		Collections.shuffle(list);

		if (list.get(0) == 1) {
			enemyAttack();
		}
		;

		javaFighter.fokusErlangen(damageNormal);
		focus.setVisible(true);
		attack.setDisable(true);

		if (blockImage.isVisible()) {
			blockImage.setVisible(false);
		}
		Timer focusImageTimer = new Timer();

		TimerTask focustask = new TimerTask() {
			public void run() {
				focus.setVisible(false);
				attack.setDisable(false);
			}
		};

		focusImageTimer.schedule(focustask, 200);

		BalkenAktualisieren();

		nani = javaFighter.naniMethode();
		if (nani == true) {
			finish.setDisable(false);
		}
	}

	public void Block(ActionEvent event) throws IOException {

		javaFighter.blockenMethode();
		blockImage.setVisible(true);
		block.setDisable(true);
		Timer blockenImageTimer = new Timer();

		TimerTask blockentask = new TimerTask() {
			public void run() {
				blockImage.setVisible(false);
				block.setDisable(false);
				BalkenAktualisieren();
			}
		};

		blockenImageTimer.schedule(blockentask, 1000);

		BalkenAktualisieren();

	}

	public void Finish(ActionEvent event) throws IOException {
		ki.cancel();
		javaFighter.gewinnErmitteln();
		finish.setDisable(true);
		attack.setDisable(true);
		block.setDisable(true);

		// EYES

		Timer eyesTimer = new Timer();

		TimerTask eyesTask = new TimerTask() {
			public void run() {
				eyeLeft.setVisible(true);
				eyeRight.setVisible(true);
			}
		};

		eyesTimer.schedule(eyesTask, 3000);

		// Explosion

		Timer explosionTimer = new Timer();

		TimerTask explosionTask = new TimerTask() {
			public void run() {
				explosion.setVisible(true);
			}
		};

		explosionTimer.schedule(explosionTask, 4500);

		// Crater

		Timer craterTimer = new Timer();

		TimerTask craterTask = new TimerTask() {
			public void run() {
				explosion.setVisible(false);
				crater.setVisible(true);
				eyeLeft.setVisible(false);
				eyeRight.setVisible(false);
				battleTheme.close();
			}
		};

		craterTimer.schedule(craterTask, 8732);

		// WIN

		Timer winTimer = new Timer();

		TimerTask winTask = new TimerTask() {
			public void run() {
				winner.setVisible(true);
				try {

					AudioInputStream yay = AudioSystem.getAudioInputStream(
							new File("C:\\Users\\Manue\\Desktop\\Studium\\Programmieren\\BeatYourEnemy\\Yay.wav"));

					Clip battleTheme = AudioSystem.getClip();
					battleTheme.open(yay);
					battleTheme.start();
					start = true;

				} catch (Exception ex) {
					System.out.println("Error with playing sound.");
					ex.printStackTrace();
				}
			}
		};

		winTimer.schedule(winTask, 10732);

	}

	public void enemyAttack() {

		boolean verloren = false;

		try {
			Random r = new Random();
			double randomValue = 1 + (3 - 1) * r.nextDouble();

			ki = new Timer();
			long interval = (long) (randomValue * 1000);

			TimerTask kitask = new TimerTask() {
				public void run() {
					javaFighter.damageMachen(damageNormal);
					nani = javaFighter.naniMethode();
					if (nani == false) {
						finish.setDisable(true);
					}
					damage.setVisible(true);
					BalkenAktualisieren();

					Timer damageImageTimer = new Timer();

					TimerTask damagetask = new TimerTask() {
						public void run() {
							damage.setVisible(false);
						}
					};

					damageImageTimer.schedule(damagetask, 200);
					// Visualisieren TESTEN
					// javaFighter.visualisieren();
				}
			};

			ki.schedule(kitask, interval);

			verloren = javaFighter.noob();

		} catch (IllegalStateException e) {
			System.out.println("EXCEPTION: " + e);
		}

		if (verloren == true) {
			System.out.println("lol noob");
			battleTheme.close();
			youDied.setVisible(true);

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
}
