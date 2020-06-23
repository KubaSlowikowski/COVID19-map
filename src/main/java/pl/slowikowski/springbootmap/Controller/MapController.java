package pl.slowikowski.springbootmap.Controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.slowikowski.springbootmap.Model.DataType;
import pl.slowikowski.springbootmap.Service.CovidParser;

import java.time.LocalDate;
import java.util.Optional;

@Controller
class MapController {
    private CovidParser covidParser;
    private LocalDate date;
    private DataType dataType;

    MapController(final CovidParser covidParser) {
        this.covidParser = covidParser;
        this.dataType = DataType.CONFIRMED;
    }

    @GetMapping(value = "/")
    public String getMap(
            Model model,
            @RequestParam(value = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") Optional<LocalDate> date,
            @RequestParam(value = "dataType") Optional<String> dataType
    ) {
        model.addAttribute("dataType", this.dataType.toString().toLowerCase());

        if (date.isPresent()) {
            if(date.get().isBefore(LocalDate.of(2020, 1, 22))) {
                model.addAttribute("errorMessage", "Za wczesna data!");
                return "map";
            }
            if(date.get().isAfter(LocalDate.now())) {
                model.addAttribute("errorMessage", "Za pozna data!");
                return "map";
            }
        }

        dataType.ifPresent(s -> {
            this.dataType = Enum.valueOf(DataType.class, s.toUpperCase());
            covidParser.setCovidData(this.dataType);
            model.addAttribute("dataType", s);
        });

        if (date.isEmpty()) {
            model.addAttribute("date", LocalDate.now());
            model.addAttribute("points", covidParser.getDataForDay(LocalDate.now()));
        } else {
            this.date = date.get();
            model.addAttribute("date", this.date);
            model.addAttribute("points", covidParser.getDataForDay(this.date));
        }
        return "map";
    }

//    @GetMapping(value = "/recovered")
//    public String getRecoveredMap(Model model, @RequestParam(value = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") Optional<LocalDate> date) {
//
//        return "map";
//    }
}