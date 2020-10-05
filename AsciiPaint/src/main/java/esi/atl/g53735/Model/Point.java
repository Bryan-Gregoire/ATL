package esi.atl.g53735.Model;

/**
 *
 * @author g53735
 */
public class Point {

    private double x;
    private double y;

    /**
     * Controller of Point.
     *
     * @param x the point on the x-axis.
     * @param y the point on the y-axis.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Move the point.
     *
     * @param dx add to the x of the point.
     * @param dy add to the y of the point.
     */
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    /**
     * Get the x.
     *
     * @return the x.
     */
    public double getX() {
        return x;
    }

    /**
     * Get the y.
     *
     * @return the y.
     */
    public double getY() {
        return y;
    }

    /**
     * Calculate the distance between 2 Points.
     *
     * @param other the other point.
     * @return the calculated distance.
     */
    public double distanceTo(Point other) {
        return Math.sqrt(
                Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    /**
     * String represent the Point.
     *
     * @return the String.
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /**
     * Indicates whether some other Point is "equal to" this one.
     *
     * @param obj the other point.
     * @return true this point is the same as the other.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Point other = (Point) obj;
        if (Double.doubleToLongBits(this.x)
                != Double.doubleToLongBits(other.x)) {
            return false;
        }
        return Double.doubleToLongBits(this.y)
                == Double.doubleToLongBits(other.y);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return the hash code value.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.x)
                ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.y)
                ^ (Double.doubleToLongBits(this.y) >>> 32));
        return hash;
    }

}
