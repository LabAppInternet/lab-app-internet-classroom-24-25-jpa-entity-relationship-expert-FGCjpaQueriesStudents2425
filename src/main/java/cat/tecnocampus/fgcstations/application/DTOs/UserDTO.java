package cat.tecnocampus.fgcstations.application.DTOs;

import java.util.List;

public record UserDTO(String username, String name, String secondName, String email, List<FavoriteJourneyDTO> favoriteJourneyList) {
}
