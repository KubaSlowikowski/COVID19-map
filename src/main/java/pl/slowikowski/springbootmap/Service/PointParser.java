package pl.slowikowski.springbootmap.Service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import pl.slowikowski.springbootmap.Model.Point;

import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
class PointParser {
    protected List<Point> parsePoints(String csvValues, LocalDate date) {
        int month = date.getMonth().getValue();
        int day = date.getDayOfMonth();
        int year = date.getYear() - 2000;

        List<Point> points = new ArrayList<>();
        StringReader stringReader = new StringReader(csvValues);
        CSVParser parses = null;
        try {
            parses = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(stringReader); //pomijam pierwszą linijkę
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (CSVRecord record : parses) {
            double lat = Double.parseDouble(record.get("Lat"));
            double lon = Double.parseDouble(record.get("Long"));
            String country = record.get("Country/Region");
            String province = record.get("Province/State");
            String cases;
            while (true) {
                try {
                    cases = record.get(month + "/" + day + "/" + year);
                    break;
                } catch (IllegalArgumentException e) {
                    day -= 1;
                }
            }
            points.add(new Point(lat, lon, cases, Double.parseDouble(cases), country, province));

        }
        return points;
    }
}