package agh.ics.oop;

class Vector2d {
    final int x;
    final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public Vector2d opposite() {
        return new Vector2d(-this.x, -this.y);
    }

    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;

        Vector2d that = (Vector2d) other;
        return this.x == that.x && this.y == that.y;
    }

    public boolean precedes(Vector2d other) {
        return this.x <= other.x && this.y <= other.y;
    }

    public boolean follows(Vector2d other) {
        return this.x >= other.x && this.y >= other.y;
    }

    public Vector2d upperRight(Vector2d other) {
        int x = this.x > other.x ? this.x : other.x;
        int y = this.y > other.y ? this.y : other.y;

        return new Vector2d(x, y);
    }

    public Vector2d lowerLeft(Vector2d other) {
        int x = this.x < other.x ? this.x : other.x;
        int y = this.y < other.y ? this.y : other.y;

        return new Vector2d(x, y);
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(this.x + other.x, this.y + other.y);
    }

    public Vector2d subtract(Vector2d other) {
        return new Vector2d(this.x - other.x, this.y - other.y);
    }

    public static void main(String[] args) {
        Vector2d position1 = new Vector2d(1, 2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2, 1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
    }
}