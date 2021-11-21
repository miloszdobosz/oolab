package agh.ics.oop;

import java.util.ArrayList;

public abstract class AbstractWorldMap implements IWorldMap{

    protected ArrayList<Animal> animals = new ArrayList<>();


    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {

        // Jest zwierzę?
        for (Animal animal: animals) {
            if (animal.getPosition().equals(position)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {

        // Jak jest tam zwierę to zwróć zwierzę
        for (Animal animal: animals) {
            if (animal.getPosition().equals(position)) {
                return animal;
            }
        }

        // Jak nie ma
        return null;
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
