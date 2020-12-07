package address;

import java.io.IOException;

import address.view.MenuController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MainUI extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage ps) {

		this.primaryStage = ps;
		this.primaryStage.setTitle("Snake Game");

		initRootLayout();
		showMenu();

	}

	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainUI.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showMenu() {
		try {
			// Load overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainUI.class.getResource("view/Menu.fxml"));
			AnchorPane menu = (AnchorPane) loader.load();

			// Set person overview into the center of root layout.
			rootLayout.setCenter(menu);
			
	        // Give the controller access to the main app.
	        MenuController controller = loader.getController();
	        controller.setMainApp(this);
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
