package cat.tecnocampus.fgcstations.api;

import cat.tecnocampus.fgcstations.application.DTOs.FriendUserDTO;
import cat.tecnocampus.fgcstations.application.DTOs.UserFriendsDTO;
import cat.tecnocampus.fgcstations.application.DTOs.UserTopFriend;
import cat.tecnocampus.fgcstations.application.FgcFriendService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class FriendRestController {
    private final FgcFriendService fgcUserService;

    public FriendRestController(FgcFriendService fgcUserService) {
        this.fgcUserService = fgcUserService;
    }

    @GetMapping("/{userName}/friends")
    public UserFriendsDTO getFriends(@PathVariable String userName) {
        return fgcUserService.getUserFriends(userName);
    }

    @GetMapping("/friends")
    public List<UserFriendsDTO> getAllFriends() {
        return fgcUserService.getAllUserFriends();
    }

    @PostMapping("/friends")
    public void saveFriends(@RequestBody @Valid UserFriendsDTO userFriendsDTO) {
        fgcUserService.saveFriends(userFriendsDTO);
    }

    @GetMapping("/topFriends")
    public List<UserTopFriend> getTop3UsersWithMostFriends() {
        return fgcUserService.getTop3UsersWithMostFriends();
    }

    @GetMapping("/friendsOf/{friend}")
    public List<FriendUserDTO> getUsersByFriend(@PathVariable String friend) {
        return fgcUserService.getUsersByFriend(friend);
    }
}
