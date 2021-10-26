package agh.ics.oop;

public class MapDirectionTest {
    @Test public boolean test() {
        assertEquals(tested.next(Direction.NORTH), Direction.EAST);
        assertEquals(tested.next(Direction.EAST), Direction.SOUTH);
        assertEquals(tested.next(Direction.SOUTH), Direction.WEST);
        assertEquals(tested.next(Direction.WEST), Direction.NORTH);

        assertEquals(tested.previous(Direction.NORTH), Direction.WEST);
        assertEquals(tested.previous(Direction.EAST), Direction.NORTH);
        assertEquals(tested.previous(Direction.SOUTH), Direction.EAST);
        assertEquals(tested.previous(Direction.WEST), Direction.SOUTH);
    }
}
