package address;

import address.model.Snake;
import address.presentation.Field;
import address.presentation.Main_UI;

public class SnakeApp {

    private static final int blockSize = 25; // size of a snake block

    private static final int width = 50;
    private static final int height = 30;
    private static Snake snake;
    private static Field field;

    public static void main(String[] args) {
        field = new Field(width, height);
        snake = new Snake(Snake.getIntitalSnakeLength(), field);
        field.addSnake(snake);
        new Main_UI().main(args);

    }

    public static int getBlockSize() {
        return blockSize;
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    public static Snake getSnake() {
        return snake;
    }

    public static Field getField() {
        return field;
    }

}
