package agh.ics.oop;

import java.util.List;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args) {
        int length = args.length;
        MoveDirection[] directions = new MoveDirection[length];

        int i = 0;
        for (String arg : args) {
            switch (arg) {
                case "f", "forward" -> directions[i] = MoveDirection.FORWARD;
                case "b", "backward" -> directions[i] = MoveDirection.BACKWARD;
                case "r", "right" -> directions[i] = MoveDirection.RIGHT;
                case "l", "left" -> directions[i] = MoveDirection.LEFT;
                default -> throw new IllegalArgumentException(arg + " is not legal move specification");
            }

            i++;
        }

        return directions;
    }
}
