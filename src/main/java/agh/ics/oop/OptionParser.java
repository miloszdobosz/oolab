package agh.ics.oop;

public class OptionParser {
    public static MoveDirection[] parse(String[] args) {
        int length = args.length;
        MoveDirection directions[] = new MoveDirection[length];

        int i = 0;
        for (String arg : args) {
            switch (arg) {
            case "f":
            case "forward":
                directions[i] = MoveDirection.FORWARD;
                i++;
                break;
            case "b":
            case "backward":
                directions[i] = MoveDirection.BACKWARD;
                i++;
                break;
            case "r":
            case "right":
                directions[i] = MoveDirection.RIGHT;
                i++;
                break;
            case "l":
            case "left":
                directions[i] = MoveDirection.LEFT;
                i++;
                break;
            }
        }

        return directions;
    }
}
