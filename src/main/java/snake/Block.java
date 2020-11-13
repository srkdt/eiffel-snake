package snake;
import javafx.scene.shape.Rectangle;

public class Block extends Rectangle {

	// static Var. für die Richtungen
	static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;

	// Var. für aktuelle und alte Position
	int posX, posY, oldPosX, oldPosY;

	Block previous;

	int direction = LEFT;

	int maxX, maxY;

	public Block(int x, int y, Block P, Field f) {
		super(Main_UI.blockSize, Main_UI.blockSize);

		this.posX = x;
		this.posY = y;

		// Argument für setTranslateX sind Pixels, wir müssen das in
		// Elementarschneck-Units umwandeln.
		setTranslateX(posX * Main_UI.blockSize);
		setTranslateY(posY * Main_UI.blockSize);

		previous = P;

		maxX = f.getW();
		maxY = f.getH();
	}

	public void update() {

		oldPosX = posX;
		oldPosY = posY;

		if (previous == null) { // head!
			switch (direction) {
			case UP:
				moveUp();
				break;
			case DOWN:
				moveDown();
				break;
			case RIGHT:
				moveRight();
				break;
			case LEFT:
				moveLeft();
				break;
			}
		} else {
			posX = previous.oldPosX;
			posY = previous.oldPosY;
		}
		// visual update:
		updatePosition();
	}

	public void moveUp() {
		posY--;
		if (posY < 0) {
			posY = maxY - 1;
		}
	}

	public void moveDown() {
		posY++;
		if (posY >= maxY) {
			posY = 0;
		}
	}

	public void moveRight() {
		posX++;
		if (posX > maxX) { // >= ?
			posX = 0;
		}
	}

	public void moveLeft() {
		posX--;
		if (posX < 0) {
			posX = maxX;
		}
	}

	// apply the movements
	public void updatePosition() {
		setTranslateX(posX * Main_UI.blockSize);
		setTranslateY(posY * Main_UI.blockSize);
	}
}
