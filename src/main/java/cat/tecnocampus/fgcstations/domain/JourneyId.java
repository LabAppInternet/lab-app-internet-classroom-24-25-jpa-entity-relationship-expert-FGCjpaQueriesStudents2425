package cat.tecnocampus.fgcstations.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;

import java.io.Serializable;

@Embeddable
public class JourneyId implements Serializable {
    private String originName;
    private String destinationName;

    public JourneyId() {
    }

    public JourneyId(String origin, String destination) {
        this.originName = origin;
        this.destinationName = destination;
    }

    public String getOriginName() {
        return this.originName;
    }

    public String getDestinationName() {
        return this.destinationName;
    }

    public void setOriginName(String origin) {
        this.originName = origin;
    }

    public void setDestinationName(String destination) {
        this.destinationName = destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JourneyId journeyId)) return false;

        if (!originName.equals(journeyId.originName)) return false;
        return destinationName.equals(journeyId.destinationName);
    }

    @Override
    public int hashCode() {
        int result = originName.hashCode();
        result = 31 * result + destinationName.hashCode();
        return result;
    }
}
