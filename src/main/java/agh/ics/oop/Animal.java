package agh.ics.oop;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);

    public String toString() {
        return orientation.toString() + ", " + position.toString();
    }

    public void move(MoveDirection direction) {

        // Fuuj
        Vector2d newPosition;

        switch (direction) {
        case FORWARD:
            newPosition = position.add(orientation.toUnitVector());
            if (newPosition.x >= 0 && newPosition.x < 5 && newPosition.y >= 0 && newPosition.y < 5)
                position = newPosition;
            break;
        case BACKWARD:
            newPosition = position.subtract(orientation.toUnitVector());
            if (newPosition.x >= 0 && newPosition.x < 5 && newPosition.y >= 0 && newPosition.y < 5)
                position = newPosition;
            break;
        case LEFT:
            orientation = orientation.previous();
            break;
        case RIGHT:
            orientation = orientation.next();
            break;
        }
    }
}