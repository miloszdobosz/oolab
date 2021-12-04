package agh.ics.oop;

import java.util.concurrent.ConcurrentSkipListMap;

public class MapBoundary implements IPositionChangeObserver {
    protected ConcurrentSkipListMap<Vector2d, Object> x = new ConcurrentSkipListMap();
    protected ConcurrentSkipListMap<Vector2d, Object> y = new ConcurrentSkipListMap();

    public void place(Object object) {
        if (object instanceof Animal animal) {
            Vector2d position = animal.getPosition();
            x.put(position, animal);
            y.put(position.reverse(), animal);
        } else if (object instanceof Grass grass) {
            Vector2d position = grass.getPosition();
                if (!x.containsKey(position)) {
                    x.put(position, grass);
                    y.put(position.reverse(), grass);
                }
        }
    }

    public Vector2d getStart() {
        return x.firstKey().lowerLeft(y.firstKey().reverse());
    }

    public Vector2d getEnd() {
        return x.lastKey().upperRight(y.lastKey().reverse());
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        x.put(newPosition, x.remove(oldPosition));
        y.put(newPosition.reverse(), y.remove(oldPosition.reverse()));
    }
}
