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
        }
    }


    @Override
    public Object objectAt(Vector2d position) {
        Object object = super.objectAt(position);
        if (object == null) object = grass.get(position);
        return object;
    }

    @Override
    protected Vector2d[] findMinMax() {

        // Znajdowanie granic mapy

        Vector2d vector = new Vector2d(0, 0);
        final Vector2d[] minMax = {vector, vector};

        grass.keySet().forEach((key) -> {
            minMax[0] = key.lowerLeft(minMax[0]);
            minMax[1] = key.upperRight(minMax[1]);
        });

        animals.keySet().forEach((key) -> {
            minMax[0] = key.lowerLeft(minMax[0]);
            minMax[1] = key.upperRight(minMax[1]);
        });

        return minMax;
    }
}
