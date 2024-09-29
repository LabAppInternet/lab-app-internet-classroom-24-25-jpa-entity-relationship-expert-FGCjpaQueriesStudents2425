package cat.tecnocampus.fgcstations.persistence;

import cat.tecnocampus.fgcstations.application.DTOs.JourneyDTO;
import cat.tecnocampus.fgcstations.domain.Journey;
import cat.tecnocampus.fgcstations.domain.JourneyId;
import cat.tecnocampus.fgcstations.domain.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JourneyRepository extends JpaRepository<Journey, JourneyId> {

    List<JourneyDTO> findAllDTOBy();

    Optional<Journey> findByOrigin_NameAndDestination_Name(String origin, String destination);

    @Query("SELECT j.id FROM Journey j WHERE j.origin.name = :origin AND j.destination.name = :destination")
    Optional<JourneyId> findJourneyIdByOriginNameAndDestinationName(String origin, String destination);
    // WORKS BUT I AM THINKING ON A DERIVED QUERY, JUST THAT THE PROJECTION TO THE INTERFACE MAKES ME DOUBT


}
