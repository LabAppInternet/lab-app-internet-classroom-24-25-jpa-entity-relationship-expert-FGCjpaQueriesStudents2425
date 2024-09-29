package cat.tecnocampus.fgcstations.persistence;

import cat.tecnocampus.fgcstations.application.DTOs.PopularDayOfWeek;
import cat.tecnocampus.fgcstations.application.DTOs.UserDTOInterface;
import cat.tecnocampus.fgcstations.application.DTOs.UserDTOnoFJ;
import cat.tecnocampus.fgcstations.application.DTOs.UserTopFavoriteJourney;
import cat.tecnocampus.fgcstations.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {


    Optional<UserDTOnoFJ> findDTOnoFJByUsername(String username);
    Optional<UserDTOInterface> findDTOInterfaceByUsername(String username);

    @Query(value = "SELECT u.username as username, u.name as name, u.second_name as secondName, u.email as email, count(fj.journey_id) as numberOfFavoriteJourneys " +
            "FROM user u " +
            "LEFT JOIN favorite_journey fj ON u.username = fj.username " +
            "WHERE u.username = :username " +
            "GROUP BY u.username, u.name, u.second_name, u.email " +
            "ORDER BY numberOfFavoriteJourneys DESC " +
            "LIMIT 3", nativeQuery = true)
    List<UserTopFavoriteJourney> findTop3FavoriteJourneysByUsername(String username);
    // WORKS BUT I AM THINKING ON A DERIVED QUERY, JUST THAT THE PROJECTION TO THE INTERFACE MAKES ME DOUBT


    List<UserDTOInterface> findAllDTOInterfaceByNameAndSecondName(String name, String secondName);



    @Query("SELECT d.dayOfWeek as dayOfWeek, COUNT(d) as count " +
            "FROM DayTimeStart d " +
            "GROUP BY d.dayOfWeek " +
            "ORDER BY count DESC")
    List<PopularDayOfWeek> getPopularDayOfWeek();
    // WORKS BUT I AM THINKING ON A DERIVED QUERY, JUST THAT THE PROJECTION TO THE INTERFACE MAKES ME DOUBT

}
