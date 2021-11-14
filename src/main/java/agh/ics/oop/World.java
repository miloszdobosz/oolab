package agh.ics.oop;

import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
    }

    static void run(Direction[] args) {
        for (Direction arg : args) {
            switch (arg) {
                case FORWARD -> out.println("zwierzak idzie do przodu");
                case BACKWARD -> out.println("zwierzak idzie do tylu");
                case RIGHT -> out.println("zwierzak idzie w prawo");
                case LEFT -> out.println("zwierzak idzie w lewo");
            }
        }
    }

    static Direction[] transform(String[] args) {
        int length = args.length;
        Direction directions[] = new Direction[length];

        int i = 0;
        for (String arg : args) {
            switch (arg) {
                case "f" -> {
                    directions[i] = Direction.FORWARD;
                    i++;
                }
                case "b" -> {
                    directions[i] = Direction.BACKWARD;
                    i++;
                }
                case "r" -> {
                    directions[i] = Direction.RIGHT;
                    i++;
                }
                case "l" -> {
                    directions[i] = Direction.LEFT;
                    i++;
                }
            }
        }

        return directions;
    }
}
