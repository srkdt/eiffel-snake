package snake;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main_UI extends Application {

	static int blockSize = 10;// pixels

	// 1280x720 - fullHD Auflösung
	int width = 128, height = 72;

	// initial length of snake
	int il = 5;

	// globale Zeitvariable für Frames
	long then = System.nanoTime();

	@Override
	public void start(Stage ps) {

		/*
		 * vertical box ist parent container! alle Elemente müssen mit getChildren()
		 * zugefügt weden
		 */
		VBox root = new VBox(10); // 10px spacing
		root.setPadding(new Insets(10));

		Field f = new Field(width, height);
		// add snake with initial length and field:
		f.addSnake(new Snake(il, f));

		Label score = new Label("Punkte: 0");

		// AnimationTimer ist eine unendliche Schleife - Handler wird mit jeden Frame
		// aktualisiert
		AnimationTimer timer = new AnimationTimer() {
			public void handle(long now) {
				if (now - then > 100000000) {
					f.update();
					then = now;
					score.setText("Score: " + f.score);
				}
			}
		};
		timer.start();

		root.getChildren().addAll(f, score);

		Scene scene = new Scene(root);

		// listen to keyboard input for mvt:
		scene.setOnKeyPressed(e -> {
			// KeyCode code = e.getCode();
			if (e.getCode().equals(KeyCode.UP) && f.snake.getDirection() != Block.DOWN) {
				f.snake.setDirection(Block.UP);
			}
			if (e.getCode().equals(KeyCode.DOWN) && f.snake.getDirection() != Block.UP) {
				f.snake.setDirection(Block.DOWN);
			}
			if (e.getCode().equals(KeyCode.RIGHT) && f.snake.getDirection() != Block.LEFT) {
				f.snake.setDirection(Block.RIGHT);
			}
			if (e.getCode().equals(KeyCode.LEFT) && f.snake.getDirection() != Block.RIGHT) {
				f.snake.setDirection(Block.LEFT);
			}
		});

		ps.setResizable(false);
		ps.setScene(scene);
		ps.setTitle("Snake Game");

		ps.show();

	}

	// launch javaFX application
	public static void main(String[] args) {
		launch(args);
	}
}
