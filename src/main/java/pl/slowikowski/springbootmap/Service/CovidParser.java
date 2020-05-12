package pl.slowikowski.springbootmap.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.slowikowski.springbootmap.Model.Circle;

import java.util.List;

@Service
public class CovidParser {

    private static final String url = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

    public List<Circle> getCovidData() {
        RestTemplate restTemplate = new RestTemplate();
        String values = restTemplate.getForObject(url, String.class);
        PointParser pointParser = new PointParser();

        return pointParser.parsePoints(values);
    }
}