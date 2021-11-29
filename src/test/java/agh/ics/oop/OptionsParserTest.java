package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class OptionsParserTest {
    @Test
    public void test() {
        OptionsParser parser = new OptionsParser();

        String[] args1 = {"f", "b", "l", "r"};
        String[] args2 = {"eeeeee!"};

        MoveDirection[] result1 = {
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.LEFT,
                MoveDirection.RIGHT
        };

        try {
            assertEquals(parser.parse(args1), result1);
            parser.parse(args2);
        } catch (IllegalArgumentException exception) {
            assertTrue(exception != null);
        }
    }
}