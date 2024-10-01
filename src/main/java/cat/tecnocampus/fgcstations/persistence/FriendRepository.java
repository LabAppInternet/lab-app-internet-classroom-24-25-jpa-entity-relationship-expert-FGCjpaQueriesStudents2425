package cat.tecnocampus.fgcstations.persistence;

import cat.tecnocampus.fgcstations.application.DTOs.FriendUserDTO;
import cat.tecnocampus.fgcstations.application.DTOs.UserTopFriend;
import cat.tecnocampus.fgcstations.domain.Friend;
import cat.tecnocampus.fgcstations.domain.FriendId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friend, FriendId> {

    List<Friend> findAllByUserUsername(String username);
    @Query("SELECT u.username as username, u.name as name, u.secondName as secondName, u.email as email, count(f.id) as numberOfFriends " +
            "FROM User u " +
            "LEFT JOIN Friend f ON u.username = f.id.username " +
            "GROUP BY u.username, u.name, u.secondName, u.email " +
            "ORDER BY numberOfFriends DESC " +
            "LIMIT 3")
    List<UserTopFriend> findTop3UsersWithMostFriends();
    // WORKS BUT I AM THINKING ON A DERIVED QUERY, JUST THAT THE PROJECTION TO THE INTERFACE MAKES ME DOUBT


    @Query("SELECT f.user FROM Friend f WHERE f.id.friend = :friendName")
    List<FriendUserDTO> findAllUsersByFriendName(String friendName);
    // WORKS BUT I AM THINKING ON A DERIVED QUERY, JUST THAT THE PROJECTION TO THE INTERFACE MAKES ME DOUBT


}
