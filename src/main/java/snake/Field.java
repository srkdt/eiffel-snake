package snake;

import java.util.ArrayList;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Field extends Pane {

	private int w, h; // width, height andere Name wegen Blocks

	ArrayList<Block> blocks = new ArrayList<Block>();
	int score = 0;
	Food f;
	Snake snake;

	// Konstruktor
	public Field(int width, int height) {// in Pixels, nicht Blocks

		this.w = width;
		this.h = height;

		setMinSize(w * Main_UI.blockSize, h * Main_UI.blockSize);
		setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, null, null)));
		setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
		addFood();
		// setBackground(new Background(new BackgroundFill(Color.AQUA, null, null)));

	}

	public void addSnake(Snake s) {
		this.snake = s;
		for (Block b : s.blocks) {
			addBlock(b);
		}
	}

	// update method in the field: update every block
	public void update() {
		for (Block b : blocks) {
			b.update();
		}
		// check ob Kopf auf Apfel ist
		if (isEaten(f)) {
			score += 1;
			addFood();
			addNewBlock();
		}
	}

	//
	public void addNewBlock() {
		Block b = new Block(snake.tail.oldPosX, snake.tail.oldPosY, snake.tail, this);
		snake.tail = b;
		addBlock(b);
	}

	// add Blocks from Snake to ArrayList in the Field
	private void addBlock(Block b) {
		getChildren().add(b); // visual
		blocks.add(b); // to ArrayList
	}

	public void addFood() {
		int randomX = (int) (Math.random() * w);
		int randomY = (int) (Math.random() * h);

		Food food = new Food(randomX, randomY);
		// zum Pane hinfügen:
		getChildren().add(food);
		getChildren().remove(f);
		f = food;
	}

	public boolean isEaten(Food f) {
		if (f == null) {
			return false;
		}
		return f.getPosX() == snake.head.posX && f.getPosY() == snake.head.posY;
	}

	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}
}
