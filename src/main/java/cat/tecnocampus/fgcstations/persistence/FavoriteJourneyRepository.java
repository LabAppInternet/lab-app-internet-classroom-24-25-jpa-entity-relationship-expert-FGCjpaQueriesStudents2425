package cat.tecnocampus.fgcstations.persistence;

import cat.tecnocampus.fgcstations.application.DTOs.FavoriteJourneyDTO;
import cat.tecnocampus.fgcstations.domain.FavoriteJourney;
import cat.tecnocampus.fgcstations.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FavoriteJourneyRepository extends JpaRepository<FavoriteJourney, String> {

    //TODO optional: Try to implement the query to get the FavoriteJourneysDTO of a user with its list of DayTimeStartDTO.
    // Is it possible to do it with a single query?

    @Query("SELECT fj FROM FavoriteJourney fj WHERE fj.user = :user")
    List<FavoriteJourney> findFavoriteJourneysDTOByUser(User user);


}
