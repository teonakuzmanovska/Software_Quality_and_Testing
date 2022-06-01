package pit_aud;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TicketPriceCalculatorTest {
    private static int ADULT_TICKET_PRICE = 40;
    private static int CHILD_TICKET_PRICE = 20;
    private TicketPriceCalculator calculator = new TicketPriceCalculator();

    @Test
    public void calculatePriceForOneAdult() {
        List<Passenger> passengers = new ArrayList<>();
        Passenger passenger = new Passenger(20);
        passenger.setAge(23);
        passengers.add(passenger);
        double price = calculator.calculatePrice(passengers, ADULT_TICKET_PRICE, CHILD_TICKET_PRICE);
        assertEquals(ADULT_TICKET_PRICE, price, 0);

        // delta se broj na otstapuvanja od ochekuvaniot odgovor
    }

    @Test
    public void calculatePriceForChild() {
        List<Passenger> passengers = new ArrayList<>();
        Passenger childPassenger = new Passenger(15);
        passengers.add(childPassenger);
        double price = calculator.calculatePrice(passengers, ADULT_TICKET_PRICE, CHILD_TICKET_PRICE);
        assertEquals(CHILD_TICKET_PRICE, price, 0);
    }

    @Test
    public void calculatePriceForFamily() {
        List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger adultPassenger2 = new Passenger(20);
        Passenger childPassenger3 = new Passenger(12);
        Passenger childPassenger4 = new Passenger(4);
        passengers.add(adultPassenger1);
        passengers.add(adultPassenger2);
        passengers.add(childPassenger3);
        passengers.add(childPassenger4);
        double price = calculator.calculatePrice(passengers, ADULT_TICKET_PRICE, CHILD_TICKET_PRICE);
        assertEquals((2 * ADULT_TICKET_PRICE + 2 * CHILD_TICKET_PRICE) *
                (1 - TicketPriceCalculator.FAMILY_DISCOUNT), price, 0);
    }


    // narrow = deteto e na granichna vozrast
    @Test
    public void calculatePriceForChildNarrowCase() {
        List<Passenger> passengers = new ArrayList<>();
        Passenger childPassenger = new Passenger(18);
        passengers.add(childPassenger);
        double price = calculator.calculatePrice(passengers, ADULT_TICKET_PRICE, CHILD_TICKET_PRICE);
        assertEquals(CHILD_TICKET_PRICE, price, 0);
    }

    @Test
    public void calculatePriceForFreeTicketNarrowCase() {
        List<Passenger> passengers = new ArrayList<>();
        Passenger childPassenger = new Passenger(3);
        passengers.add(childPassenger);
        double price = calculator.calculatePrice(passengers, ADULT_TICKET_PRICE, CHILD_TICKET_PRICE);
        assertEquals(0, price, 0);
    }

    @Test
    public void shouldNotCalculatePriceForFamily() {
        List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger childPassenger2 = new Passenger(12);
        passengers.add(adultPassenger1);
        passengers.add(childPassenger2);
        double price = calculator.calculatePrice(passengers, ADULT_TICKET_PRICE, CHILD_TICKET_PRICE);
        assertEquals((ADULT_TICKET_PRICE + CHILD_TICKET_PRICE), price, 0);
    }

    @Test
    public void shouldNotCalculatePriceForFamilyEdgeCaseWithAdults() {
        List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger adultPassenger2 = new Passenger(20);
        Passenger childPassenger1 = new Passenger(12);
        passengers.add(adultPassenger1);
        passengers.add(adultPassenger2);
        passengers.add(childPassenger1);
        double price = calculator.calculatePrice(passengers, ADULT_TICKET_PRICE, CHILD_TICKET_PRICE);
        assertEquals((2 * ADULT_TICKET_PRICE + CHILD_TICKET_PRICE), price, 0);
    }

    @Test
    public void shouldNotCalculatePriceForFamilyEdgeCaseWithChildren() {
        List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger childPassenger1 = new Passenger(12);
        Passenger childPassenger2 = new Passenger(12);
        passengers.add(adultPassenger1);
        passengers.add(childPassenger1);
        passengers.add(childPassenger2);
        double price = calculator.calculatePrice(passengers, ADULT_TICKET_PRICE, CHILD_TICKET_PRICE);
        assertEquals((ADULT_TICKET_PRICE + 2 * CHILD_TICKET_PRICE), price, 0);
    }

}