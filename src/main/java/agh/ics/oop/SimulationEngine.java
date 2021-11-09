package agh.ics.oop;

public class SimulationEngine implements IEngine{
    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions) {
        for (Vector2d position : positions) {
            map.place(new Animal(map, position, MapDirection.NORTH));
        }
    }

    @Override
    public void run() {

    }
}
