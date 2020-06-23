package pl.slowikowski.springbootmap.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.slowikowski.springbootmap.Model.DataType;
import pl.slowikowski.springbootmap.Model.Point;

import java.time.LocalDate;
import java.util.List;

@Service
public class CovidParser {

    private static final String URL_CONFIRMED = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
    private static final String URL_RECOVERED = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_recovered_global.csv";
    private static final String URL_DEATHS = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_deaths_global.csv";
    private String values;

    CovidParser() {
        values = getCovidData();
    }

    private static String getCovidData() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(URL_CONFIRMED, String.class);
    }

    public void setCovidData(DataType dataType) {
        String url = null;
        RestTemplate restTemplate = new RestTemplate();
        if (dataType.equals(DataType.CONFIRMED)) {
            url = URL_CONFIRMED;
        } else if (dataType.equals(DataType.RECOVERED)) {
            url = URL_RECOVERED;
        } else if (dataType.equals(DataType.DEATHS)) {
            url = URL_DEATHS;
        }
            values = restTemplate.getForObject(url, String.class);
        }

        public List<Point> getDataForDay (LocalDate date){
            PointParser pointParser = new PointParser();
            return pointParser.parsePoints(values, date);
        }
    }