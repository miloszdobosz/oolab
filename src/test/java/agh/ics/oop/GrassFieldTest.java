package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrassFieldTest {
    @Test
    public void test() {
        GrassField grassField = new GrassField(100);

        assertTrue(grassField.canMoveTo(new Vector2d(5, 17)));
        assertTrue(grassField.canMoveTo(new Vector2d(-10010, 0)));
        assertTrue(grassField.canMoveTo(new Vector2d(500, 500)));
        assertTrue(grassField.canMoveTo(new Vector2d(-4510, -9010)));


        Vector2d position = new Vector2d(5, 5);
        Animal animal = new Animal(grassField, position);

        grassField.place(animal);

        assertTrue(grassField.isOccupied(position));
        assertEquals(grassField.objectAt(position), animal);

        try {
            grassField.place(animal);
        } catch (IllegalArgumentException exception) {
            assertTrue(exception != null);
        }
    }
}

