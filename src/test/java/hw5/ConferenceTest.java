package hw5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static hw5.Role.*;
import static org.junit.jupiter.api.Assertions.*;

class ConferenceTest {
    public static double TICKET_PRICE = 8.67;
    public static double AFFILIATE_DISCOUNT = 0.1;
    public static double FACULTY_EMPLOYEE_DISCOUNT = 0.7;

    @Test
    public void calculatePriceOtherFullCapacity(){

        Conference conference = new Conference(3);

        Person person1 = new Person("Teona", "Kuzmanovska", OTHER, 21);
        Person person2 = new Person("Teona", "Teonovska", AFFILIATE, 30);
        Person person3 = new Person("Teona", "Teonovska", FACULTY_EMPLOYEE, 40);

        conference.addAttendeeToConference(person1);
        conference.addAttendeeToConference(person2);
        conference.addAttendeeToConference(person3);

        double price = conference.calculateTotalPricePaid();

        assertEquals((1 - FACULTY_EMPLOYEE_DISCOUNT) * TICKET_PRICE + (1 - AFFILIATE_DISCOUNT) * TICKET_PRICE + TICKET_PRICE, price, 0);

    }

    @Test
    public void addAttendeeToConferenceAboveLimit() {

        Conference conference = new Conference(6000);

        for (int i = 0; i < conference.getCapacity(); i++)
            conference.addAttendeeToConference(new Person("Teona", "Kuzmanovska", STUDENT, 21));

        assertFalse(conference.addAttendeeToConference(new Person("Teona", "Teonovska", OTHER, 21)));

    }

    @Test
    public void addAttendeeToConferenceBellowLimit() {

        Conference conference = new Conference(50);

        for (int i = 0; i < conference.getCapacity(); i++)
            conference.addAttendeeToConference(new Person("Teona", "Kuzmanovska", STUDENT, 21));

        assertTrue(conference.addAttendeeToConference(new Person("Teona", "Teonovska", OTHER, 21)));

    }

    @Test
    public void doubleSizeAboveCapacity(){

        Conference conference = new Conference(9000);
        assertFalse(conference.doubleCapacity());

    }

    @Test
    public void doubleSizeBellowCapacity(){

        Conference conference = new Conference(4);

        Person person1 = new Person("Teona", "Kuzmanovska", STUDENT, 21);
        Person person2 = new Person("Teona", "Teonovska", OTHER, 30);

        conference.addAttendeeToConference(person1);
        conference.addAttendeeToConference(person2);

        assertTrue(conference.doubleCapacity());
        assertTrue(conference.getAttendees().size() < conference.getCapacity());

    }

    @Test
    public void doubleSizeNarrow(){

        Conference conference = new Conference(5000);
        assertTrue(conference.doubleCapacity());

    }

    @Test
    public void getAttendees() {
        Conference conference = new Conference(10);
        List<Person> personList = new ArrayList<>();

        Person person = new Person("Teona", "Kuzmanovska", STUDENT, 21);

        personList.add(person);
        conference.addAttendeeToConference(person);

        assertEquals(personList, conference.getAttendees());
    }

    @Test
    public void toStringTest() {

        Person person = new Person("Teona", "Kuzmanovska", STUDENT, 21);

        person.setAge(21);
        person.setSurname("Kuzmanovska");
        person.setRole(OTHER);

        person.toString();
        assertEquals("Person{" + "name='" + "Teona" + '\'' + ", surname='" + "Kuzmanovska" + '\'' + ", role=" + OTHER + ", age=" + "21" + '}', person.toString());
    }
}