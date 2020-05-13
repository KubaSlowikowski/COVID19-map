package pl.slowikowski.springbootmap.Model;

public class Circle extends Point {

    private double lat;
    private double lon;
    private double radius;
    private String cases;
    private String country;
    private String province;

    public Circle(Point point) {
        this(point.getLat(), point.getLon(), null, 50, null, null);
    }

    public Circle(final double lat, final double lon, final String cases, final double radius, final String country, final String province) {
        this.lat = lat;
        this.lon = lon;
        this.cases = cases;
        this.radius = radius;
        this.country = country;
        this.province = province;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(final String province) {
        this.province = province;
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
}