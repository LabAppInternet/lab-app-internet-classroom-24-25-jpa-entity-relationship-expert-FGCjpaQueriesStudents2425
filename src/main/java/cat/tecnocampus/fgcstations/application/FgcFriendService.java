package cat.tecnocampus.fgcstations.application;


import cat.tecnocampus.fgcstations.application.DTOs.FriendUserDTO;
import cat.tecnocampus.fgcstations.application.DTOs.UserFriendsDTO;
import cat.tecnocampus.fgcstations.application.DTOs.UserTopFriend;
import cat.tecnocampus.fgcstations.application.mapper.MapperHelper;
import cat.tecnocampus.fgcstations.domain.Friend;
import cat.tecnocampus.fgcstations.domain.User;
import cat.tecnocampus.fgcstations.persistence.FriendRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FgcFriendService {
    private final FriendRepository friendRepository;
    private final FcgUserService fcgUserService;

    public FgcFriendService(FriendRepository friendRepository, FcgUserService fcgUserService) {
        this.friendRepository = friendRepository;
        this.fcgUserService = fcgUserService;
    }

    public UserFriendsDTO getUserFriends(String username) {
        // TODO 20: find all the friends of a user given her username. You can solve this exercise without any sql query
        return MapperHelper.listOfAUserFriendsToUserFriendsDTO(friendRepository.findAllByUserUsername(username));

    }

    public List<UserFriendsDTO> getAllUserFriends() {
        // TODO 21: find all the friends (domain) of all users. You can solve this exercise without leaving this file
        //  note that domain objects are mapped to DTOs
        return MapperHelper.allUserFriendListToListUserFriendsDTO(friendRepository.findAll()); // replace the empty list with the list of all users
    }

    public void saveFriends(UserFriendsDTO userFriendsDTO) {
        User user = fcgUserService.getDomainUser(userFriendsDTO.getUsername());
        friendRepository.saveAll(MapperHelper.friendsDTOToUserListOfFriends(user, userFriendsDTO));
    }

    public List<UserTopFriend> getTop3UsersWithMostFriends() {
        // TODO 22: find the top 3 users with the most friends.
        return friendRepository.findTop3UsersWithMostFriends();
    }

    // Find all users whose friends have a certain name
    public List<FriendUserDTO> getUsersByFriend(String friendName) {
        // TODO 23: find all users whose friends have a certain name.
        return friendRepository.findAllUsersByFriendName(friendName);
    }

}
