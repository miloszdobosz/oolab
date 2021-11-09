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
        this.position = initialPosition;
    }

    public Animal(IWorldMap map, Vector2d initialPosition, MapDirection initialOrientation) {
        this.map = map;
        this.position = initialPosition;
        this.orientation = initialOrientation;
    }

    public String toString() {
        return orientation.toString();
    }

    public void move(MoveDirection direction) {
        this.position.add(this.orientation.toUnitVector());

        if (!this.map.canMoveTo(position)) {
            this.position.subtract(this.orientation.toUnitVector());
        }
    }

    public Vector2d getPosition() {
        return position;
    }
}
