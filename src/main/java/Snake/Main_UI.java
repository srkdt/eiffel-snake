package Snake;
import java.util.Optional;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main_UI extends Application {

	static int block_size = 20;

	int width = 30, height = 20; // donne les dimensions du terrain de jeu dans lequel le snake va jouer

	int il = 5; // taille initiale du serpent

	long then = System.nanoTime();

	boolean changed = false;
	int nextUpdate;
	boolean hasNext = false;

	Scene startScene, scene, stopScene, lostScene;
	Field f;
	Button buttonStart, buttonExit, buttonReturnMenu, buttonExitInGame, buttonRestartWhenLost, buttonBackToMenuWhenLost,
			buttonExitWhenLost;

	public void start(Stage ps) {

		VBox start = new VBox(10);		
		
		start.setBackground(new Background(new BackgroundFill(Color.BLACK, null , null))); // set the background color 
				
		// Initializations of buttonStart 

		buttonStart = new Button("START"); // initializes buttonStart as a new button	

		buttonStart.setPrefSize(250, 100); // set width and height of the buttonStart

		buttonStart.setTranslateX(130); // positions button in X axes
		buttonStart.setTranslateY(40); // positions button in Y axes 
		
		buttonStart.setTextFill(Color.BLACK); // set the text color in the button
		
		buttonStart.setStyle("-fx-background-color: pink"); // initializes button color 
		
		Font s = new Font("Arial", 28); // can change the size and writing of the text in the button 
		buttonStart.setFont(s);
		
		
		// Initializations of buttonExit

		buttonExit = new Button("EXIT"); // initializes buttonExit as a new button	
	
		buttonExit.setPrefSize(100, 30);  // set width and height of the buttonExit

		buttonExit.setTranslateX(205); // positions button in X axes
		buttonExit.setTranslateY(80); // positions button in Y axes

		buttonExit.setTextFill(Color.BLACK); // set the text color in the button
		
		buttonExit.setStyle("-fx-background-color: red"); // initializes button color
		
		
		// Initializations of buttonReturnMenu

		buttonReturnMenu = new Button("Back to Menu"); // initializes buttonReturnMenu as a new button	
		
		buttonReturnMenu.setTranslateX(500); // positions button in X axes
		buttonReturnMenu.setTranslateY(-40); // positions button in Y axes
		
		buttonReturnMenu.setStyle("-fx-background-color: pink"); // initializes button color
		
		
		
		// Initializations of buttonExitInGame

		buttonExitInGame = new Button("EXIT"); // initializes buttonExitInGame as a new button	
		
		buttonExitInGame.setTranslateX(500); // positions button in X axes
		buttonExitInGame.setTranslateY(-20); // positions button in Y axes
		
		buttonExitInGame.setStyle("-fx-background-color: red"); // initializes button color
		
		
		// Initializations of buttonRestartWhenLost
		
		buttonRestartWhenLost = new Button("Restart"); // initializes buttonRestartWhenLost as a new button	
		
		buttonRestartWhenLost.setPrefSize(100, 50); // set width and height of the buttonRestartWhenLost
		
		buttonRestartWhenLost.setTranslateX(190); // positions button in X axes
		buttonRestartWhenLost.setTranslateY(20); // positions button in Y axes
		
		buttonRestartWhenLost.setStyle("-fx-background-color: green"); // initializes button color
	
		
		// Initializations of buttonBackToMenuWhenLost
		
		buttonBackToMenuWhenLost = new Button("Back to Menu"); // initializes buttonBackToMenuWhenLost as a new button	
		
		buttonBackToMenuWhenLost.setPrefSize(100, 50); // set width and height of the buttonBackToMenuWhenLost
		
		buttonBackToMenuWhenLost.setTranslateX(190); // positions button in X axes
		buttonBackToMenuWhenLost.setTranslateY(30); // positions button in Y axes
		
		buttonBackToMenuWhenLost.setStyle("-fx-background-color: pink"); // initializes button color
		
		// Initializations of buttonExitWhenLost
		
		buttonExitWhenLost = new Button("Exit"); // initializes buttonExitWhenLost as a new button	

		buttonExitWhenLost.setPrefSize(100, 50); // set width and height of the buttonExitWhenLost
		
		buttonExitWhenLost.setTranslateX(190); // positions button in X axes
		buttonExitWhenLost.setTranslateY(40); // positions button in Y axes
		
		buttonExitWhenLost.setStyle("-fx-background-color: red"); // initializes button color
		
		
		
		Label score = new Label(" Score : 0 ");
		score.setFont(Font.font("Arial", 32));

		f = new Field(width, height);

		f.addSnake(new Snake(il, f));

		VBox root = new VBox(10, f, score, buttonReturnMenu, buttonExitInGame);
		root.setPadding(new Insets(10));

		scene = new Scene(root);

		AnimationTimer timer = new AnimationTimer() {
			public void handle(long now) {

				if (now - then > 1000000000 / 8) { // vitesse a laquelle l'affichage est mis a jours
					f.update();
					then = now;
					score.setText("Score: " + f.score);
					changed = false;

					if (hasNext) {
						setDirection(f.snake, nextUpdate);
						hasNext = false;
					}

					if (f.isDead()) {

						VBox lost = new VBox(10);
						Label finalScore = new Label("          Your final Score is : " + f.score);
						finalScore.setFont(Font.font("Arial", 32));
						
						lost.getChildren().addAll(finalScore, buttonRestartWhenLost, buttonBackToMenuWhenLost,
								buttonExitWhenLost);

						lostScene = new Scene(lost, 500, 300);

						ps.setScene(lostScene);
						ps.show();

						buttonRestartWhenLost.setOnAction(new EventHandler<ActionEvent>() {

							public void handle(ActionEvent event) {

								root.getChildren().clear();
								f = new Field(width, height);
								f.addSnake(new Snake(il, f));
								score.setText("Score : 0");
								root.getChildren().addAll(f, score, buttonReturnMenu, buttonExitInGame);

								ps.setResizable(false);
								ps.setScene(scene);
								ps.setTitle("Snake Game");

								ps.show();
							}

						});

						buttonBackToMenuWhenLost.setOnAction(new EventHandler<ActionEvent>() {

							public void handle(ActionEvent event) {

								ps.setScene(startScene);
								ps.show();
							}

						});

						buttonExitWhenLost.setOnAction(new EventHandler<ActionEvent>() {

							public void handle(ActionEvent event) {

								System.exit(0);
							}

						});

					}
				}
			}
		};

		timer.start();

		scene.setOnKeyPressed(e -> {
			if (e.getCode().equals(KeyCode.UP) && f.snake.getDirection() != Block.DOWN) {
				setDirection(f.snake, Block.UP);
			}
			if (e.getCode().equals(KeyCode.DOWN) && f.snake.getDirection() != Block.UP) {
				setDirection(f.snake, Block.DOWN);
			}
			if (e.getCode().equals(KeyCode.RIGHT) && f.snake.getDirection() != Block.LEFT) {
				setDirection(f.snake, Block.RIGHT);
			}
			if (e.getCode().equals(KeyCode.LEFT) && f.snake.getDirection() != Block.RIGHT) {
				setDirection(f.snake, Block.LEFT);
			}
		});

		buttonStart.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				root.getChildren().clear();
				f = new Field(width, height);
				f.addSnake(new Snake(il, f));
				score.setText("Score : 0");
				root.getChildren().addAll(f, score, buttonReturnMenu, buttonExitInGame);

				ps.setResizable(false);
				ps.setScene(scene);
				ps.setTitle("Snake Game");

				ps.show();
			}

		});

		buttonExit.setOnAction(new EventHandler<ActionEvent>() { // met en action le boutton pour quitter interface

			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
			}
		});

		start.getChildren().addAll(buttonStart, buttonExit);
		startScene = new Scene(start, 500, 300);
		ps.setTitle("Snake Game");
		ps.setScene(startScene);
		ps.show();

		buttonReturnMenu.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				ps.setScene(startScene);
				ps.show();
			}
		});

		buttonExitInGame.setOnAction(new EventHandler<ActionEvent>() { // met en action le boutton pour quitter
																		// interface

			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
			}
		});

		
	}

	public void setDirection(Snake s, int d) {
		if (!changed) {
			s.setDirection(d);
			changed = true;
		} else {
			hasNext = true;
			nextUpdate = d;
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}
