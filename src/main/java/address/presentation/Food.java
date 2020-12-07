package address.presentation;

import address.SnakeApp;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Food extends Rectangle {

	int posX, posY;

	public Food(int x, int y) {

		super(SnakeApp.getBlockSize(), SnakeApp.getBlockSize());

		this.posX = x;
		this.posY = y;

		setTranslateX(posX * SnakeApp.getBlockSize());
		setTranslateY(posY * SnakeApp.getBlockSize());

		setFill(Color.color(Math.random(), Math.random(), Math.random()));
		setStroke(Color.BLACK);
		setArcHeight(SnakeApp.getBlockSize());
		setArcWidth(SnakeApp.getBlockSize());

	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

}
