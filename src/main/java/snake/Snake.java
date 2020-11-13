package snake;
import java.util.ArrayList;

import javafx.scene.paint.Color;

public class Snake {

	ArrayList<Block> blocks = new ArrayList<Block>();

	Block head;
	Block tail;

	public Snake(int il, Field f) {// initial length, und Field um Zentrum zu berechnen
		int ipx = f.getW() / 2; // init pos X
		int ipy = f.getH() / 2;

		head = new Block(ipx, ipy, null, f);
		blocks.add(head);
		head.setFill(Color.CORNFLOWERBLUE);
		head.setArcHeight(10);
		head.setArcWidth(4);

		tail  = head;

		for (int i = 1; i < il; i++) {
			Block b = new Block(ipx + i, ipy, tail, f);
			blocks.add(b); // zu ArrayList hinfügen
			tail = b;
			// tail.setFill(Color.DARKGOLDENROD);
		}

	}

	public void setDirection(int d) {
		head.direction = d;
	}

	public int getDirection() {
		return head.direction;
	}

}
