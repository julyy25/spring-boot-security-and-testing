package in.project.myproject.modal.demo;

import java.util.Collections;
import java.util.List;

// Immuatbaility
// Record
// Hexagonal
// Cold Start
final class Person {
    private final String firstName;
    private final String lastName;
    private final List<String> friendList;

    public Person(String firstName, String lastName, List<String> friendList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.friendList = Collections.unmodifiableList(friendList);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<String> getFriendList() {
        return friendList;
    }
}
