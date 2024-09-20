package cat.tecnocampus.fgcstations.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_fcg")
public class User implements Serializable {

    @Id
    private String username;

    private String name;
    private String secondName;

    private String email;

    @Transient
    public List<FavoriteJourney> favoriteJourneyList;

    public User() {
       favoriteJourneyList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<FavoriteJourney> getFavoriteJourneyList() {
        return favoriteJourneyList;
    }

    public void setFavoriteJourneyList(List<FavoriteJourney> favoriteJourneyList) {
        this.favoriteJourneyList = favoriteJourneyList;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                ", favoriteJourneyList=lazy" +
                '}';
    }
}
