package agh.ics.oop;

import java.util.ArrayList;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position;
    private IWorldMap map;
    private ArrayList<IPositionChangeObserver> observers = new ArrayList<>();

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
        switch (direction) {
            case FORWARD -> {
                Vector2d newPosition = orientation.toUnitVector().add(position);
                if (map.canMoveTo(newPosition)) {
                    positionChanged(newPosition);
                    position = newPosition;
                }
            }
            case BACKWARD -> {
                Vector2d newPosition = orientation.toUnitVector().opposite().add(position);
                if (map.canMoveTo(newPosition)) {
                    positionChanged(newPosition);
                    position = newPosition;
                }
            }
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
        }
    }

    public Vector2d getPosition() {
        return position;
    }

    public void addObserver(IPositionChangeObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer) {
        this.observers.remove(observer);
    }

    public void positionChanged(Vector2d newPosition) {
        for (IPositionChangeObserver observer: observers) {
            observer.positionChanged(position, newPosition);
        }
    }
}
