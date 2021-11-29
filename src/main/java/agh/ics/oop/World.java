package agh.ics.oop;

import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        try {
            MoveDirection[] directions = new OptionsParser().parse(args);
            IWorldMap map = new RectangularMap(10, 5);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        } catch (IllegalArgumentException exception) {
            out.println(exception);
        }
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
}
