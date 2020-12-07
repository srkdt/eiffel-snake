package address.view;

import java.io.IOException;

import address.MainUI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MenuController {

	@FXML
	Button buttonStart;
	@FXML
	Button buttonExit;

	private MainUI MainUI;

	public void setMainApp(MainUI mainUI) {
		this.MainUI = mainUI;
	}

}
