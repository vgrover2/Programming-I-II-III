//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Battle System
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
import java.util.NoSuchElementException;


/**
 * @author vedantgrover
 * 
 * This class implements unit test methods to check the correctness of the implementation of the
 * MoveQueue, and BattleCharacter classes defined in the CS300 Fall 2020 - P10 BattleSystem
 * programming assignment.
 *
 */
public class BattleSystemTester {
  
  /**
   * Calls tester methods
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println("testClear(): " + testClear());
    System.out.println("testMoveQueueConstructors(): " + testMoveQueueConstructors());
    System.out.println("testEnqueueMoveQueue(): " + testEnqueueMoveQueue());
    System.out.println("testDequeueMoveQueue(): " + testDequeueMoveQueue());

  }
  
  /**
   * 
   * Test method which tests the correctness of the two constructors in the MoveQueue class 
   * as well as involing the size() and isEmpty() methods
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.   *
   */
  public static boolean testMoveQueueConstructors() {
    boolean test = true;
    
    MoveQueue tempQueue = new MoveQueue(); //testing constructor without parameter
    MoveQueue tempQueue2 = new MoveQueue(3); //testing constructor with parameter
    
    
    if(!(tempQueue.isEmpty())) {
      test = false;
    }
    
    if(tempQueue2.size() != 0) {
      test = false;
    }
    
    try {
      MoveQueue tempQueue3 = new MoveQueue(0);
      test = false; //should never reach this as exception is expected
    }
    catch(IllegalArgumentException e) {
      
    }
    return test;
    
  }
  
  /**
   * 
   * Test method which tests the correctness of the clear() method in the MoveQueue class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.   
   */
  public static boolean testClear() {
    boolean test = true;
    
    MoveQueue tempQueue = new MoveQueue(10);
    MoveQueue tempQueue2 = new MoveQueue(5); //creating threee different Queues 
    MoveQueue tempQueue3 = new MoveQueue(2);
    
    tempQueue.clear();
    if(tempQueue.size() != 0) {
      test = false;
    }
    tempQueue2.clear();
    if(!(tempQueue2.isEmpty())) {
      test =  false;
    }
    tempQueue3.clear();
    if(tempQueue3.size() != 0) {
      test = false;
    }
    return test;
  }
  
  /**
   * 
   * Test method which checks the correctness of the enqueue operation implemented 
   * in the MoveQueue class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.   
   */

  public static boolean testEnqueueMoveQueue(){
    boolean test = true;
    
    MoveQueue tempQueue = new MoveQueue();
    int[] tempArray = {5, 6, 7, 8, 9};
    
    BattleCharacter tempElement = new BattleCharacter("Pete", tempArray);
    tempQueue.enqueue(tempElement);
    
    if(tempQueue.size() != 1) {
      test = false;
    }
    if(!(tempElement.equals(tempQueue.peekBest()))) {
      test = false;
    }
    
    
    MoveQueue tempQueue2 = new MoveQueue();
    BattleCharacter tempElement2 = null;
    
    try {
      tempQueue2.enqueue(tempElement2);
      test = false; //should never reach this as exception is expected
    }
    catch(IllegalArgumentException e) {
      
    }
    
    MoveQueue tempQueue3 = new MoveQueue(2); //capacity of only 2 set 
    int[] tempArray2 = {10, 6, 1, 8, 2};
    int[] tempArray3 = {7, 6, 9, 8, 3};
    int[] tempArray4 = {2, 3, 8, 8, 5};
    BattleCharacter tempElement3 = new BattleCharacter("Jack", tempArray2);
    BattleCharacter tempElement4 = new BattleCharacter("Ishaan", tempArray3);
    BattleCharacter tempElement5 = new BattleCharacter("Ananya", tempArray4);
    
    tempQueue3.enqueue(tempElement3);
    tempQueue3.enqueue(tempElement4); //queue is full at this point
    if(tempQueue3.size() != 2) {
      test = false;
    }
    try {
      tempQueue3.enqueue(tempElement5);
      test = false; //should never reach this as exception is expected
    }
    catch(IllegalStateException e) {
      
    }
    
    return test;
    
  }
  
  /**
   * 
   * Test method which checks the correctness of the dequeue operation implemented
   * in the MoveQueue class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.   
   */

  public static boolean testDequeueMoveQueue(){
    boolean test = true;
    
    MoveQueue tempQueue = new MoveQueue(5);
    int[] tempArray = {11, 6, 1, 9, 4};
    int[] tempArray2 = {11, 6, 1, 9, 4};
    int[] tempArray3 = {11, 6, 1, 9, 4};
    BattleCharacter tempElement = new BattleCharacter("Tom", tempArray);
    BattleCharacter tempElement2 = new BattleCharacter("Bill", tempArray2);
    BattleCharacter tempElement3 = new BattleCharacter("Bob", tempArray3);
    tempQueue.enqueue(tempElement);
    tempQueue.enqueue(tempElement2);
    tempQueue.enqueue(tempElement3); //3 elements stored inside the queue
    
    if(tempQueue.size() != 3) {
      test = false;
    }
    
    tempQueue.dequeue();
    
    if(tempQueue.size() != 2) {
      test = false;
    }
    
    if(!(tempQueue.dequeue().equals(tempElement2))) {
      test = false;
    }
    
    if(tempQueue.size() != 1) {
      test = false;
    }
    tempQueue.dequeue();
    
    if(tempQueue.size() != 0) {
      test = false;
    }
    
    try {
      tempQueue.dequeue();
      test = false; //should never reach this as exception is expected
    }
    catch(NoSuchElementException e) {
      
    }
    return test;
  }
  
}
