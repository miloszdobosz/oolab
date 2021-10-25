package agh.ics.oop;

import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        out.println("Start");
        run(transform(args));
        out.println("Stop");

        Vector2d position1 = new Vector2d(1, 2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2, 1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        Animal animal = new Animal();
        System.out.println(animal.toString());
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        System.out.println(animal.toString());
    }

    static void run(Direction[] args) {
        for (Direction arg : args) {
            switch (arg) {
                case FORWARD:
                    out.println("zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    out.println("zwierzak idzie do tylu");
                    break;
                case RIGHT:
                    out.println("zwierzak idzie w prawo");
                    break;
                case LEFT:
                    out.println("zwierzak idzie w lewo");
                    break;
            }
        }
    }

    static Direction[] transform(String[] args) {
        int length = args.length;
        Direction directions[] = new Direction[length];

        int i = 0;
        for (String arg : args) {
            switch (arg) {
                case "f":
                    directions[i] = Direction.FORWARD;
                    i++;
                    break;
                case "b":
                    directions[i] = Direction.BACKWARD;
                    i++;
                    break;
                case "r":
                    directions[i] = Direction.RIGHT;
                    i++;
                    break;
                case "l":
                    directions[i] = Direction.LEFT;
                    i++;
                    break;
            }
        }

        return directions;
    }
}
