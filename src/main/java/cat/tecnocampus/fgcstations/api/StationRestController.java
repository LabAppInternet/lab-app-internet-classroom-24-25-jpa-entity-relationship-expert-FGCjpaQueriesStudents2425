package cat.tecnocampus.fgcstations.api;

import cat.tecnocampus.fgcstations.application.DTOs.StationDTO;
import cat.tecnocampus.fgcstations.application.DTOs.StationTopFavoriteJourney;
import cat.tecnocampus.fgcstations.application.FgcStationService;
import cat.tecnocampus.fgcstations.domain.Station;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stations")
public class StationRestController {
    private final FgcStationService fgcStationService;

    public StationRestController(FgcStationService fgcStationService) {
        this.fgcStationService = fgcStationService;
    }

    @GetMapping("")
    public List<StationDTO> getStations() {
        return fgcStationService.getStationsDTO();
    }

    @GetMapping("/domain")
    public List<Station> getStationsDomain() {
        return fgcStationService.getStationsDomain();
    }

    @GetMapping("/{nom}")
    public StationDTO getStation(@PathVariable String nom) {
        return fgcStationService.getStationDTO(nom);
    }

    @GetMapping("/topFavoriteJourney")
    public List<StationTopFavoriteJourney> getStationsTopFavoriteJourney() {
        return fgcStationService.getStationsOrderedByFavoriteJourneysAsEitherOriginOrDestination();
    }
}
