package agh.ics.oop;

import java.util.ArrayList;
import java.util.Collection;

public class SimulationEngine implements IEngine{
    private IWorldMap map;
    private MoveDirection[] moves;
    private Vector2d[] positions;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions) {
        this.map = map;
        this.moves = moves;
        this.positions = positions;

        for (Vector2d position : positions) {
            map.place(new Animal(map, position, MapDirection.NORTH));
        }
    }

    @Override
    public void run() {
        int i = 0;
        for (MoveDirection move: moves) {
            Animal animal = (Animal) map.objectAt(positions[i]);
            animal.move(move);
            positions[i % positions.length] = animal.getPosition();
            i++;
        }
    }
}
