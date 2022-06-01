package hw4;//Homework4

public class VacationPlans
{
    public boolean canGoOnVacation(Person person, VacationDates vacationDates)
    {
        System.out.println("This program checks if a person can go on a vacation during a particular time.");

        boolean canGo = ((person.moneySaved > person.moneyNeeded)
                && (!vacationDates.datesAreWorkingDays || (person.canUseVacationDays == 1)));

        if (canGo)
            return true;
        return false;
    }
}
