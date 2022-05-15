// Introduction to Software Testing
// Authors: Paul Ammann & Jeff Offutt
// Chapter 7; page ??
// Can be run from command line
// See PrintPrimes.num for a numbered version.
// No JUnit tests at this time

/** *****************************************************
 * Finds and prints n prime integers
 * Jeff Offutt, Spring 2003
 ********************************************************* */

// Homework 2
public class PrintPrimes
{

    private static boolean isDivisible (int i, int j)
    {
        if (j%i == 0)
            return true;
        else
            return false;
    }
    private static void printPrimes (int n)
    {
        int curPrime;           // Value currently considered for primeness
        int numPrimes;          // Number of primes found so far.
        boolean isPrime;        // Is curPrime prime?
        int [] primes = new int [100]; // The list of prime numbers.

        // Initialize 2 into the list of primes.
        primes [0] = 2;
        numPrimes = 1;
        curPrime  = 2;

        // NODE 3
        while (numPrimes < n) // --n=5 n=7
        {
            // NODE 4
            curPrime++;  // next number to consider ... // --curPrime=9
            isPrime = true;

            // NODE 5
            for (int i = 0; i <= numPrimes-1; i++) // NODE 8 --i<=4
            {   // for each previous prime.

                // NODE 6
                if (isDivisible (primes[i], curPrime)) // --9/2 9/3
                {  // Found a divisor, curPrime is not prime.

                    // NODE 7
                    isPrime = false;
                    break; // out of loop through primes.
                }
            }
            // NODE 9
            if (isPrime) // --za 5
            {   // save it!

                // NODE 10
                primes[numPrimes] = curPrime; // --primes[2] = 5
                numPrimes++; // --3
            }
        }  // End while

        // NODE 11
        // Print all the primes out.
        for (int i = 0; i <= numPrimes-1; i++) // NODE 13
        {
            // NODE 12
            System.out.println ("Prime: " + primes[i]);
        }
    }  // end printPrimes NODE 14

    public static void main (String []argv)
    {  // Driver method for printPrimes
        // Read an integer from standard input, call printPrimes()
        int integer=5;
//        if (argv.length != 1)
//        {
//            System.out.println ("Usage: java PrintPrimes v1 ");
//            return;
//        }
//
//        try
//        {
//            integer = Integer.parseInt (argv[0]);
//        }
//        catch (NumberFormatException e)
//        {
//            System.out.println ("Entry must be a integer, using 1.");
//            integer = 1;
//        }

        printPrimes (integer);
    }
}
