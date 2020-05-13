package pl.slowikowski.springbootmap.Model;


public class Point {

    private double lat;
    private double lon;

    Point() {
    }

    public Point(final double lat, final double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(final double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(final double lon) {
        this.lon = lon;
    }

    public Circle toCirle() {
        return new Circle(this);
    }
}
