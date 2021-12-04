package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {
    @Test
    public void test() {
        RectangularMap rectangularMap = new RectangularMap(10, 10);

        assertTrue(rectangularMap.canMoveTo(new Vector2d(5, 5)));
        assertTrue(rectangularMap.canMoveTo(new Vector2d(10, 10)));

        assertFalse(rectangularMap.canMoveTo(new Vector2d(-1, -1)));
        assertFalse(rectangularMap.canMoveTo(new Vector2d(11, 11)));


        Vector2d position = new Vector2d(5, 5);
        Animal animal = new Animal(rectangularMap, position);

        rectangularMap.place(animal);

        assertTrue(rectangularMap.isOccupied(position));
        assertEquals(rectangularMap.objectAt(position), animal);

        try {
            rectangularMap.place(animal);
        } catch (IllegalArgumentException exception) {
            assertNotNull(exception);
        }
    }
}
