package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap{
    private final Vector2d start;
    private final Vector2d size;

    public RectangularMap(int width, int height) {
        start = new Vector2d(0, 0);
        size = new Vector2d(width, height);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return super.canMoveTo(position) && start.precedes(position) && size.follows(position);
    }

    @Override
    protected Vector2d[] findMinMax() {
        return new Vector2d[]{this.start, this.size};
    }
}
