package agh.ics.oop;

import java.util.HashMap;

public class RectangularMap implements IWorldMap{
    private Vector2d start;
    private Vector2d size;
    private HashMap<Vector2d, Object> map;

    public RectangularMap(int width, int height) {
        start = new Vector2d(0, 0);
        size = new Vector2d(width, height);
        map = new HashMap<>(width * height);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) && start.precedes(position) && size.follows(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            map.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return map.containsKey(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        return map.get(position);
    }

    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(this.start, this.size);
    }
}
