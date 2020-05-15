package pl.slowikowski.springbootmap.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.slowikowski.springbootmap.Model.Point;

import java.time.LocalDate;
import java.util.List;

@Service
public class CovidParser {

    private static final String url = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
    private static String values;

    CovidParser() {
        values = getCovidData();
    }



    private static String getCovidData() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }

    public List<Point> getDataForDay(LocalDate date) {
        PointParser pointParser = new PointParser();
        return pointParser.parsePoints(values, date);
    }
}