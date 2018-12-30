package JavaFighter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.sound.sampled.Clip;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * HowToPlay!
 * 
 * @author Manue
 *
 */
public class MainMenuController implements Initializable {

	@FXML
	private Clip thisclip;
	@FXML
	private Button fightButton;
	@FXML
	private Button howToPlayButton;
	@FXML
	private StackPane parentContainer;
	@FXML
	private AnchorPane anchorMenu;
	@FXML
	private Pane howtoplay;
	@FXML
	private Button closeText;
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
	private MenuItem choosewizard1;
	@FXML
	private MenuItem choosewizard2;
	@FXML
	private MenuItem choosepresident1;
	@FXML
	private MenuItem choosepresident2;
	@FXML
	private MenuItem choosewaluigi1;
	@FXML
	private MenuItem choosewaluigi2;
	@FXML
	private MenuItem choosewombat1;
	@FXML
	private MenuItem choosewombat2;
	@FXML
	private String character1 = "";
	@FXML
	private String character2 = "";

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	public void ChooseWizard1(ActionEvent event) throws IOException {
		wizard1.setVisible(true);
		president1.setVisible(false);
		waluigi1.setVisible(false);
		wombat1.setVisible(false);
		character1 = "wizard";
	}

	@FXML
	public void ChooseWizard2(ActionEvent event) throws IOException {
		wizard2.setVisible(true);
		president2.setVisible(false);
		waluigi2.setVisible(false);
		wombat2.setVisible(false);
		character2 = "wizard";
	}

	@FXML
	public void ChoosePresident1(ActionEvent event) throws IOException {
		wizard1.setVisible(false);
		president1.setVisible(true);
		waluigi1.setVisible(false);
		wombat1.setVisible(false);
		character1 = "president";
	}

	@FXML
	public void ChoosePresident2(ActionEvent event) throws IOException {
		wizard2.setVisible(false);
		president2.setVisible(true);
		waluigi2.setVisible(false);
		wombat2.setVisible(false);
		character2 = "president";
	}

	@FXML
	public void ChooseWaluigi1(ActionEvent event) throws IOException {
		wizard1.setVisible(false);
		president1.setVisible(false);
		waluigi1.setVisible(true);
		wombat1.setVisible(false);
		character1 = "waluigi";
	}

	@FXML
	public void ChooseWaluigi2(ActionEvent event) throws IOException {
		wizard2.setVisible(false);
		president2.setVisible(false);
		waluigi2.setVisible(true);
		wombat2.setVisible(false);
		character2 = "waluigi";
	}

	@FXML
	public void ChooseWombat1(ActionEvent event) throws IOException {
		wizard1.setVisible(false);
		president1.setVisible(false);
		waluigi1.setVisible(false);
		wombat1.setVisible(true);
		character1 = "wombat";
	}

	@FXML
	public void ChooseWombat2(ActionEvent event) throws IOException {
		wizard2.setVisible(false);
		president2.setVisible(false);
		waluigi2.setVisible(false);
		wombat2.setVisible(true);
		character2 = "wombat";
	}

	@FXML
	public void HowToPlay(ActionEvent event) throws IOException {
		howtoplay.setVisible(true);
	}

	@FXML
	public void CloseText(ActionEvent event) throws IOException {
		howtoplay.setVisible(false);
	}

	@FXML
	public void Fight(ActionEvent event) throws IOException {

		try {
			thisclip.close();

			Stage oldstage = (Stage) fightButton.getScene().getWindow();
			oldstage.close();

			FXMLLoader loader = new FXMLLoader(getClass().getResource("JavaFighterBattleScene.fxml"));

			Parent root = (Parent) loader.load();
			BattleSceneController controller = loader.getController();
			controller.Character1(character1);
			controller.Character2(character2);
			Stage stage = new Stage();
			stage.setTitle("BattleScene");
			stage.setScene(new Scene(root));
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void MusikBeenden(Clip clip) {
		thisclip = clip;

	}
}
