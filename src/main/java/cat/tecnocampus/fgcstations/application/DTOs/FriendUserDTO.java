package cat.tecnocampus.fgcstations.application.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface FriendUserDTO {
    @JsonProperty("username")
    String getUserUsername();
    @JsonProperty("name")
    String getUserName();
}
