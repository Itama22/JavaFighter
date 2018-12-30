package JavaFighter;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class IntroController implements Initializable {

	@FXML
	private Button button;
	@FXML
	private StackPane parentContainer;
	@FXML
	private AnchorPane anchorRoot;
	@FXML
	private Text textbox;
	@FXML
	private Clip clip;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		try {

			AudioInputStream theme = AudioSystem.getAudioInputStream(
					new File("C:\\Users\\Manue\\Desktop\\Studium\\Programmieren\\BeatYourEnemy\\EduardLaser.wav"));

			clip = AudioSystem.getClip();
			clip.open(theme);
			clip.start();

		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}

	}

	@FXML
	public void SpielStarten(ActionEvent event) throws IOException {

		try {

			AudioInputStream start = AudioSystem.getAudioInputStream(
					new File("C:\\Users\\Manue\\Desktop\\Studium\\Programmieren\\BeatYourEnemy\\StartSound.wav"));

			Clip startClip = AudioSystem.getClip();
			startClip.open(start);
			startClip.start();

		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}

		Stage oldstage = (Stage) button.getScene().getWindow();
		oldstage.close();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("JavaFighterMenu.fxml"));

		Parent root = (Parent) loader.load();
		MainMenuController controller = loader.getController();
		controller.MusikBeenden(clip);
		Stage stage = new Stage();
		stage.setTitle("Main Menu");
		stage.setScene(new Scene(root));
		stage.show();

	}

}
