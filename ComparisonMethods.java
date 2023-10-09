//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Benchamrking
// Course: CS 300 Fall 2020
//
// Author: Vedant Grover
// Email: vgrover2@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: None
// Online Sources: None
//
///////////////////////////////////////////////////////////////////////////////

public class ComparisonMethods {
    
    /*
     * @param sum is the sum of all integers 1 to n
     * @return the sum as a long 
     * 
     * Complexity: O(N)
     */
    
    public static long bruteForce(long n) {
        long sum = 0;
        for(int i = 1; i <= n; i++) {
            sum = sum + i;
        }
        return sum;
    }
    /*
     * @param sum is the sum of all integers 1 to n
     * @return the sum as a long 
     * 
     * Complexity: O(1)
     * 
     */
    public static long constantTime(long n) {
        //in order to maximise accuracy the calculation of sum step has been split into 2 lines
        long sum = (n)*(n+1);
        sum = sum/2;
        return sum;
    }

}
