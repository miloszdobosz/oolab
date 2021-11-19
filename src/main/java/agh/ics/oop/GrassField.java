package agh.ics.oop;

import java.util.*;

public class GrassField implements IWorldMap{
    int number;
    private int grassSize;

    // Nie jestem w czym w przyszłości przydatne będzie trzymanie tego, ale na razie wydaje się sensowne:
    private HashMap<Vector2d, Grass> grass;
    private ArrayList<Animal> animals;

    public GrassField(int number) {
        this.number = number;
        this.grassSize = (int) Math.sqrt(number*10);

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

        // Jak jest tam trawa to zwróć trawę
        if (grass.containsKey(position)) {
            return grass.get(position);
        }

        // Jak jest zwierz to zwierza
        for (Animal animal: animals) {
            if (animal.getPosition().equals(position)) {
                return animal;
            }
        }

        return null;
    }

    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);

        // Znajdowanie granic mapy w bolesny sposób

        Vector2d[] array = (Vector2d[]) grass.keySet().toArray();
        Vector2d min = array[0];
        Vector2d max = array[0];
        for (Vector2d element: array) {
            if (element.precedes(min)) min = element;
            if (element.follows(max)) min = element;
        }

        for (Vector2d element: array) {
            if (element.precedes(min)) min = element;
            if (element.follows(max)) min = element;
        }

        return visualizer.draw(min, max);
    }
}
