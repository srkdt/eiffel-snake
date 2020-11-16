package Snake;

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

		setFill(Color.AQUA);
		setStroke(Color.MEDIUMPURPLE);
		setArcHeight(10);
		setArcWidth(10);

	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

}