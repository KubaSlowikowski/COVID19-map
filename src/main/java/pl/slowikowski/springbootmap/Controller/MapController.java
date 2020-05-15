package pl.slowikowski.springbootmap.Controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.slowikowski.springbootmap.Service.CovidParser;

import java.time.LocalDate;
import java.util.Optional;

@Controller
class MapController {
    private CovidParser covidParser;

    MapController(final CovidParser covidParser) {
        this.covidParser = covidParser;
    }

    @GetMapping(value = "/")
    public String getMap(Model model, @RequestParam(value = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") Optional<LocalDate> date) {
        if(date.isEmpty()) {
            model.addAttribute("date", LocalDate.now());
            model.addAttribute("points", covidParser.getDataForDay(LocalDate.now()));
        } else {
            model.addAttribute("date", date.get());
            model.addAttribute("points", covidParser.getDataForDay(date.get()));
        }
        return "map";
    }
}