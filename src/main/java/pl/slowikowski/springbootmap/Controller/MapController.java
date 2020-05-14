package pl.slowikowski.springbootmap.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.slowikowski.springbootmap.Service.CovidParser;

@Controller
class MapController {
    private CovidParser covidParser;

    MapController(final CovidParser covidParser) {
        this.covidParser = covidParser;
    }

    @GetMapping
    public String getMap(Model model) {
        model.addAttribute("points", covidParser.getCovidData());
//        model.addAttribute("circles", circlesList);
        return "map";
    }
}