package agh.ics.oop;

import java.util.Objects;

public class Vector2d implements Comparable<Vector2d>{
    final int x;
    final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public Vector2d opposite() {
        return new Vector2d(-this.x, -this.y);
    }

    public Vector2d reverse() {
        return new Vector2d(this.y, this.x);
    }

    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Vector2d that))
            return false;

        return this.x == that.x && this.y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }

    public boolean precedes(Vector2d other) {
        return this.x <= other.x && this.y <= other.y;
    }

    public boolean follows(Vector2d other) {
        return this.x >= other.x && this.y >= other.y;
    }

    public Vector2d upperRight(Vector2d other) {
        int x = Math.max(this.x, other.x);
        int y = Math.max(this.y, other.y);

        return new Vector2d(x, y);
    }

    public Vector2d lowerLeft(Vector2d other) {
        int x = Math.min(this.x, other.x);
        int y = Math.min(this.y, other.y);

        return new Vector2d(x, y);
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(this.x + other.x, this.y + other.y);
    }

    public Vector2d subtract(Vector2d other) {
        return new Vector2d(this.x - other.x, this.y - other.y);
    }

    @Override
    public int compareTo(Vector2d other) {
        if (this.precedes(other)) return -1;
        if (this.follows(other)) return 1;
        return 0;
    }
}