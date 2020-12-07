package address.model;

import java.util.ArrayList;

import address.SnakeApp;
import address.presentation.Block;
import address.presentation.Field;
import address.presentation.Main_UI;

public class Snake {

	public ArrayList<Block> blocks = new ArrayList<Block>();

	public static int intitalSnakeLength = 5;

	public Block head;
	public Block tail;

	public Snake(int il, Field f) {
		int ipx = f.getW() / 2;
		int ipy = f.getH() / 2;

		head = new Block(ipx, ipy, null, f);
		blocks.add(head);

		head.setArcHeight(SnakeApp.getBlockSize()  / 2);
		head.setArcWidth(SnakeApp.getBlockSize() / 2);

		tail = head;

		for (int i = 1; i < il; i++) {
			Block b = new Block(ipx + i, ipy, tail, f);
			blocks.add(b);
			tail = b;
		}
	}

	public int getDirection() {
		return head.direction;
	}

	public static int getIntitalSnakeLength() {
		return intitalSnakeLength;
	}

	public void setDirection(int d) {
		head.direction = d;
	}
}
