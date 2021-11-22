package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{

    protected HashMap<Vector2d, Animal> animals = new HashMap<>();


    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d position = animal.getPosition();
        if (canMoveTo(position)) {
            animals.put(position, animal);
            return true;
        }
        return false;
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

    protected Vector2d[] findMinMax() {
        Vector2d vector = new Vector2d(0, 0);
        return new Vector2d[]{vector, vector};
    }

    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        Vector2d[] minMax = findMinMax();
        return visualizer.draw(minMax[0], minMax[1]);
    }
}
