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
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
public class Benchmarker {

    public static void main(String[] args) {
       
        File file = new File("file.txt");
        
        //Creating a test array
        
        long[] sampleArray = new long[] {1, 10, 25, 46, 137};
        createResultsFile(file, sampleArray);

    }
    
    /*
     * @param bruteForceValue is the sum caluclated through brute force method
     * @param constantTimeValue is sum calculated through formula method
     * 
     * @return a formatted string with 'n' and the elapsed times
     * 
     * @throws NoSuchElementException if the sum calculated through both methods aren't the same
     * 
     */
    
    public static String compare(long n) throws NoSuchElementException{
        //Calculating the time each method takes 
        long start = System.currentTimeMillis();
        long bruteForceValue = ComparisonMethods.bruteForce(n);
        long end = System.currentTimeMillis();
        long bruteForceTime = end - start;
        
        long start2 = System.currentTimeMillis();
        long constantTimeValue = ComparisonMethods.constantTime(n);
        long end2 = System.currentTimeMillis();
        long formulaTime = end2-start2;
        //checking if two values are the same 
        if(!(bruteForceValue == constantTimeValue)) {
            throw new NoSuchElementException("Error: The two methods don't give the same value");
        }
        //the two times get returned next to each other within a string 
        return n + "\t" + bruteForceTime + "\t" + formulaTime + "\n";
    }
    
    /*
     * @param fw is the filewriter object that gets created
     * @param f is the file on which each value from array is written to
     * 
     * @throws IOException if the filewriter object doesn't get created
     * @throws IOException if there was an error while writing to the filewriter object
     * @throws IOException if the filwriter was unable to close
     * 
     */
    
    public static void createResultsFile(File f, long[] queryNs) {
        //defining as null outside try-catch block so is avaialble throughout the method
        FileWriter fw = null;
        try {
            fw = new FileWriter(f);
        }
        catch(IOException e) {
            System.out.println("Exception encountered, unable to complete method.");
        }
        //iterating through array outside try-catch so IOException can use index for exception message
        for(int i =0; i < queryNs.length; i++) {
            try {
                fw.write(compare(queryNs[i]));
            }
            catch(NoSuchElementException nsee) {
                System.out.println(nsee.getMessage());
                continue;
            }
            catch(IOException e) {
                System.out.println("Exception encountered while writing for value N = " + queryNs[i]);
            }
        }
        try {
            fw.close();
        }
        catch(IOException e) {
            System.out.println("Exception encountered while closing file.");
        }
    }
}
