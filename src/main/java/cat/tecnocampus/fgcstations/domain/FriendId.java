package cat.tecnocampus.fgcstations.domain;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class FriendId implements Serializable {

    private String username;
    private String friend;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }

    public String getUsername() {
        return username;
    }

    public String getFriend() {
        return friend;
    }
}
