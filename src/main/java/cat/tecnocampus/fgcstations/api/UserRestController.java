package cat.tecnocampus.fgcstations.api;

import cat.tecnocampus.fgcstations.application.DTOs.*;
import cat.tecnocampus.fgcstations.application.FcgUserService;
import cat.tecnocampus.fgcstations.domain.FavoriteJourney;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    private final FcgUserService fgcUserService;

    public UserRestController(FcgUserService fcgUserService) {
        this.fgcUserService = fcgUserService;
    }

    @GetMapping("")
    public List<UserDTO> getUsers() {
        return fgcUserService.getUsers();
    }

    @GetMapping("/topFavoriteJourney")
    public List<UserTopFavoriteJourney> getUsersTopFavoriteJourney() {
        return fgcUserService.getTop3UsersWithMostFavoriteJourneys();
    }

    @GetMapping("/{username}/withFavoriteJourneys")
    public UserDTO getUser(@PathVariable String username) {
        return fgcUserService.getUserDTO(username);
    }

    @GetMapping("/{username}/asDTO")
    public UserDTOnoFJ getUserDTOnoFJ(@PathVariable String username) {
        return fgcUserService.getUserDTOWithNoFavoriteJourneys(username);
    }

    @GetMapping("/{username}/asInterface")
    public UserDTOInterface getUserDTOInterface(@PathVariable String username) {
        return fgcUserService.getUserDTOInterface(username);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putUser(@RequestBody @Valid UserDTOnoFJ userDTO) {
        fgcUserService.updateUser(userDTO);
    }

    @PostMapping("/{userName}/favoriteJourney")
    public void postAddFavoriteJourney(@PathVariable String userName, @RequestBody @Valid FavoriteJourneyDTO favoriteJourney) {
        fgcUserService.addUserFavoriteJourney(userName, favoriteJourney);
    }

    @GetMapping("/{userName}/favoriteJourneys")
    public List<FavoriteJourneyDTO> getFavoriteJourneys(@PathVariable String userName) {
        return fgcUserService.getFavoriteJourneysDTO(userName);
    }

    @GetMapping("/{userName}/domainFavoriteJourneys")
    public List<FavoriteJourney> getDomainFavoriteJourneys(@PathVariable String userName) {
        return fgcUserService.getFavoriteJourneys(userName);
    }

    @GetMapping("/name/{name}/secondName/{secondName}")
    public List<UserDTOInterface> getUsersByNameAndSecondName(@PathVariable String name, @PathVariable String secondName) {
        return fgcUserService.getUsersByNameAndSecondName(name, secondName);
    }

    @GetMapping("/popular/dayOfWeek")
    public List<PopularDayOfWeek> getPopularDayOfWeek() {
        return fgcUserService.getPopularDayOfWeek();
    }
}
