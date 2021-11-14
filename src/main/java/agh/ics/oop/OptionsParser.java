package agh.ics.oop;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args) {
        int length = args.length;
        MoveDirection directions[] = new MoveDirection[length];

        int i = 0;
        for (String arg : args) {
            switch (arg) {
                case "f", "forward" -> {
                    directions[i] = MoveDirection.FORWARD;
                    i++;
                }
                case "b", "backward" -> {
                    directions[i] = MoveDirection.BACKWARD;
                    i++;
                }
                case "r", "right" -> {
                    directions[i] = MoveDirection.RIGHT;
                    i++;
                }
                case "l", "left" -> {
                    directions[i] = MoveDirection.LEFT;
                    i++;
                }
            }
        }

        MoveDirection dirs[] = new MoveDirection[i];
        for (int j = 0; j < i; j++) {
            dirs[j] = directions[j];
        }

        return dirs;
    }
}
