package address.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Food extends Rectangle {

	int posX, posY;

	public Food(int x, int y) {

		super(Main_UI.blockSize, Main_UI.blockSize);

		this.posX = x;
		this.posY = y;

		setTranslateX(posX * Main_UI.blockSize);
		setTranslateY(posY * Main_UI.blockSize);

		setFill(Color.color(Math.random(), Math.random(), Math.random()));
		setStroke(Color.BLACK);
		setArcHeight(Main_UI.blockSize);
		setArcWidth(Main_UI.blockSize);

	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

}