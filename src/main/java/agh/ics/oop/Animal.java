package agh.ics.oop;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);
    private IWorldMap map;

    public Animal() {
    }

    public Animal(IWorldMap map) {
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        if (!map.isOccupied(initialPosition)) {
            map.place(this);
        }
    }

    public String toString() {
        return orientation.toString();
    }

    public void move(MoveDirection direction) {
        this.position.add(this.orientation.toUnitVector());

        if (!this.map.canMoveTo(position)) {
            this.position.subtract(this.orientation.toUnitVector());
        }

        /*// Fuuj
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
        } */
    }

    public Vector2d getPosition() {
        return position;
    }
}
