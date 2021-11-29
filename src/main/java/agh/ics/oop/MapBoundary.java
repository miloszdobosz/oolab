package agh.ics.oop;

import java.util.concurrent.ConcurrentSkipListMap;

public class MapBoundary implements IPositionChangeObserver {
    protected ConcurrentSkipListMap<Integer, Object> x = new ConcurrentSkipListMap();
    protected ConcurrentSkipListMap<Integer, Object> y = new ConcurrentSkipListMap();

    public void place(Object object) {
        if (object instanceof Animal) {
            Animal animal = (Animal) object;
            Vector2d position = animal.getPosition();
            this.x.put(position.x, animal);
            this.y.put(position.y, animal);
        }
    }

    public Vector2d getStart() {
        return new Vector2d(x.firstKey(), y.firstKey());
    }

    public Vector2d getEnd() {
        return new Vector2d(x.lastKey(), y.lastKey());
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        x.put(newPosition.x, x.remove(oldPosition.x));
        y.put(newPosition.y, y.remove(oldPosition.y));
    }
}
