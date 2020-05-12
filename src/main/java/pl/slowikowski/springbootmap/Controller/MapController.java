package pl.slowikowski.springbootmap.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.slowikowski.springbootmap.Model.Point;
import pl.slowikowski.springbootmap.Service.CovidParser;

import java.util.List;

@Controller
class MapController {
    private CovidParser covidParser;
    private List<Point> list = List.of(new Point(10, 20, "t", "PL"),
            new Point(10, 30, "t", "PL"),
            new Point(20, 30, "t", "PL"),
            new Point(20, 20, "t", "PL"));

    MapController(final CovidParser covidParser) {
        this.covidParser = covidParser;
    }

    @GetMapping
    public String getMap(Model model) {
//        model.addAttribute("points", covidParser.getCovidData());
        model.addAttribute("points", list);
        model.addAttribute("circles", covidParser.getCovidData());
        return "map";
    }
}