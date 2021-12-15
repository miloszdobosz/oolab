package agh.ics.oop;

import java.util.HashMap;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    public MapBoundary boundary = new MapBoundary();

    protected HashMap<Vector2d, Animal> animals = new HashMap<>();


    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d position = animal.getPosition();

        if (canMoveTo(position)) {
            animal.addObserver(this);
            animal.addObserver(boundary);
            animals.put(position, animal);
            boundary.place(animal);
            return true;
        }

        throw new IllegalArgumentException(position + "is already occupied");
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = animals.remove(oldPosition);
        animals.put(newPosition, animal);
    }

    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(boundary.getStart(), boundary.getEnd());
    }
}
