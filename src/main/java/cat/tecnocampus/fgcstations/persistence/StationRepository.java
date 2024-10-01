package cat.tecnocampus.fgcstations.persistence;

import cat.tecnocampus.fgcstations.application.DTOs.StationDTO;
import cat.tecnocampus.fgcstations.application.DTOs.StationTopFavoriteJourney;
import cat.tecnocampus.fgcstations.domain.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StationRepository extends JpaRepository<Station, String> {

    List<StationDTO> findAllDTOBy();

    Optional<Station> findByName(String name);

    Optional<StationDTO> findDTOByName(String name);

    @Query(value = "SELECT s.name as name, count(j.id) as count FROM station s " +
            "LEFT JOIN journey j ON s.name = j.origin_station " +
            "GROUP BY s.name " +
            "UNION " +
            "SELECT s.name as name, count(j.id) as count FROM station s " +
            "LEFT JOIN journey j ON s.name = j.destination_station " +
            "GROUP BY s.name " +
            "ORDER BY count DESC", nativeQuery = true)
    List<StationTopFavoriteJourney> getStationsOrderedByFavoriteJourneysAsEitherOriginOrDestination();

}
