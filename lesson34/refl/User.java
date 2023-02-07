package TRJavaHWs.lesson34.refl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User {

    private long id;
    private String firstName;
    private String lastName;
    private LocalDateTime birthDate;

    public User(long id, String firstName, String lastName, LocalDateTime birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    private List<Event> events = new ArrayList<>();


    private long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    private String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private LocalDateTime getBirthDate() {
        return birthDate;
    }

    private void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    private List<Event> getEvents() {
        return events;
    }

    private void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", events=" + events +
                '}';
    }
}
