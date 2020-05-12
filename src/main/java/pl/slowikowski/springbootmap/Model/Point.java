package pl.slowikowski.springbootmap.Model;


public class Point {

    private double lat;
    private double lon;
    private String cases;
    private String country;

    Point() {
    }

    public Point(final double lat, final double lon, final String cases, final String country) {
        this.lat = lat;
        this.lon = lon;
        this.cases = cases;
        this.country = country;
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

    public String getCases() {
        return cases;
    }

    public void setCases(final String cases) {
        this.cases = cases;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public Circle toCirle() {
        return new Circle(this);
    }
}
