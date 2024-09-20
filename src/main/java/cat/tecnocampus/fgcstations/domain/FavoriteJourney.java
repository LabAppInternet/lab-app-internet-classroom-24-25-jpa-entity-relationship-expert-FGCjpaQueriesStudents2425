package cat.tecnocampus.fgcstations.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class FavoriteJourney {

    @Id
    private String id;

    //actually it is @OneToFew
    @OneToMany(cascade = CascadeType.ALL)
    private List<DayTimeStart> dayTimeStarts;

    @ManyToOne
    private Journey journey;

    @ManyToOne
    @JsonIgnore
    private User user;


    public FavoriteJourney() {
        dayTimeStarts = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<DayTimeStart> getDayTimeStarts() {
        return dayTimeStarts;
    }

    public void setDateTimeStarts(List<DayTimeStart> startList) {
        this.dayTimeStarts = startList;
    }

    public Journey getJourney() {
        return journey;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
    }

    public void setDayTimeStarts(List<DayTimeStart> startList) {
        this.dayTimeStarts = startList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "FavoriteJourney{" +
                "id=" + id +
                //", startList=" + startList +
                ", journey=" + journey +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FavoriteJourney that = (FavoriteJourney) o;

        if (dayTimeStarts != null ? !dayTimeStarts.equals(that.dayTimeStarts) : that.dayTimeStarts != null) return false;
        return journey != null ? journey.equals(that.journey) : that.journey == null;
    }

    @Override
    public int hashCode() {
        int result = dayTimeStarts != null ? dayTimeStarts.hashCode() : 0;
        result = 31 * result + (journey != null ? journey.hashCode() : 0);
        return result;
    }
}
