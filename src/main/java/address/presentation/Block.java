package address.presentation;
import address.SnakeApp;
import javafx.scene.shape.Rectangle;

public class Block extends Rectangle {

	static  final int UP = 0 , RIGHT = 1 , DOWN = 2 , LEFT = 3 ;
	int posX, posY, oldPosX, oldPosY;
	Block previous;
	public int direction = LEFT;
	int maxX , maxY;

	public Block(int x , int y, Block p , Field f ) {
		super(SnakeApp.getBlockSize(), SnakeApp.getBlockSize());
		posX = x;
		posY = y;

		setTranslateX(posX * SnakeApp.getBlockSize());
		setTranslateY(posY * SnakeApp.getBlockSize());

		previous = p ;

		maxX = f.getW();
		maxY = f.getH();
	}

	public void update() {
		oldPosX = posX;
		oldPosY = posY;

		if(previous == null) {
			switch(direction) {
			case UP: moveUp(); break;
			case RIGHT: moveRight(); break;
			case DOWN: moveDown(); break;
			case LEFT: moveLeft(); break;

			}
			}else {
				posX = previous.oldPosX;
				posY = previous.oldPosY;
		}
		updatePosition();
	}

	public void moveUp() {
		posY--;

		if(posY < 0) {
			posY = maxY - 1;
		}
	}


	public void moveDown() {
		posY++;

		if(posY >= maxY) {
			posY = 0;
		}
	}


	public void moveLeft() {
		posX--;
		if(posX < 0) {
			posX = maxX - 1;
		}
	}


	public void moveRight() {
		posX++;

		if(posX >= maxX) {
			posX = 0;
		}
	}

	public void updatePosition() {
		setTranslateX(posX * SnakeApp.getBlockSize());
		setTranslateY(posY * SnakeApp.getBlockSize());
	}





}
