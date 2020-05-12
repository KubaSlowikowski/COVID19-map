package pl.slowikowski.springbootmap.Model;

public class Circle extends Point {

    private double lat;
    private double lon;
    private double radius;
    private String cases;

    public Circle(Point point) {
        this(point.getLat(), point.getLon(), point.getCases(), 0);
    }

    public Circle(final double lat, final double lon, final String cases, final double radius) {
        this.lat = lat;
        this.lon = lon;
        this.cases = cases;
        this.radius = radius;
    }

    @Override
    public double getLat() {
        return lat;
    }

    @Override
    public void setLat(final double lat) {
        this.lat = lat;
    }

    @Override
    public double getLon() {
        return lon;
    }

    @Override
    public void setLon(final double lon) {
        this.lon = lon;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(final double radius) {
        this.radius = radius;
    }

    @Override
    public String getCases() {
        return cases;
    }

    @Override
    public void setCases(final String cases) {
        this.cases = cases;
    }
}
