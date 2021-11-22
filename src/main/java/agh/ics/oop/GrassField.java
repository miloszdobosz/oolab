package agh.ics.oop;

import java.util.*;

public class GrassField extends AbstractWorldMap{

    private HashMap<Vector2d, Grass> grass = new HashMap<>();


    public GrassField(int number) {
        int grassSize = (int) Math.sqrt(number * 10);

        Random generator = new Random();

        for (int i = 0; i < number; i++) {
            Vector2d position = new Vector2d(generator.nextInt(grassSize), generator.nextInt(grassSize));

            while (this.grass.containsKey(position)) {
                position = new Vector2d(generator.nextInt(grassSize), generator.nextInt(grassSize));
            }

            this.grass.put(position, new Grass(position));

            recalculate(position);
        }
    }


    @Override
    public Object objectAt(Vector2d position) {
        Object object = super.objectAt(position);
        if (object == null) object = grass.get(position);
        return object;
    }

    @Override
    public boolean place(Animal animal) {
        if (super.place(animal)) {
            recalculate(animal.getPosition());
            return true;
        }

        return false;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        super.positionChanged(oldPosition, newPosition);
        recalculate(newPosition);
    }


    private void recalculate(Vector2d vector) {
        start = start.lowerLeft(vector);
        size = size.upperRight(vector);
    }
}
