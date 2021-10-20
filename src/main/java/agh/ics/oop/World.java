package agh.ics.oop;

import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        out.println("system wystartowal");
        run(transform(args));
        out.println("system zakonczyl dzialanie");
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
