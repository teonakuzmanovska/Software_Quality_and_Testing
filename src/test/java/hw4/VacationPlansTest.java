package hw4;

import hw4.Person;
import hw4.VacationDates;
import hw4.VacationPlans;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//    Homework4
class VacationPlansTest {

//    I take rows 1,5,2,4 from the truth table.

    @Test
    public void test1()
    {
        var vacationPlans = new VacationPlans();
        Person person = new Person(1,2,1); // TTT
        VacationDates vacationDates = new VacationDates(true);

        assertTrue(vacationPlans.canGoOnVacation(person, vacationDates));
    }

    @Test
    public void test2()
    {
        var vacationPlans = new VacationPlans();
        Person person = new Person(1,2,0); //TTF
        VacationDates vacationDates = new VacationDates(true);

        assertFalse(vacationPlans.canGoOnVacation(person, vacationDates));
    }

    @Test
    public void test4()
    {
        var vacationPlans = new VacationPlans();
        Person person = new Person(1,2,0); //TFF
        VacationDates vacationDates = new VacationDates(false);

        assertTrue(vacationPlans.canGoOnVacation(person, vacationDates));
    }

    @Test
    public void test5()
    {
        var vacationPlans = new VacationPlans();
        Person person = new Person(2,1,1); //FTT
        VacationDates vacationDates = new VacationDates(true);

        assertFalse(vacationPlans.canGoOnVacation(person, vacationDates));
    }

}