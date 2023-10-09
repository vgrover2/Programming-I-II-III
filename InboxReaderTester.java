//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Inbox Reader
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

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * @author vedantgrover
 * 
 * This class implements unit test methods to check the correctness of the implementation of the
 * MessageStack, Inbox, and MessageStackIterator classes defined in the CS300 Fall 2020 - P08 LIFO
 * Inbox Reader programming assignment.
 *
 */
public class InboxReaderTester {

  /**
   * Calls your tester methods
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println("testStackConstructorIsEmptyPushPeek(): " + testStackConstructorIsEmptyPushPeek());
    System.out.println("testStackPop(): " + testStackPop());
    System.out.println("testMessageStackIterator(): " + testMessageStackIterator());
    System.out.println("runInboxReaderTestSuite(): " + runInboxReaderTestSuite());
  }


  /**
   * Checks for the correctness of the constructor of the MessageStack, MessageStack.push(),
   * MessageStack.peek(), MessageStack.isEmpty(), and MessageStack.size() methods. 
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  
  public static boolean testStackConstructorIsEmptyPushPeek() {
    boolean test = true;
    
    Message msg1 = new Message("Greetings", "Hello");
    Message msg2 = new Message("School", "How was the exam?");
    MessageStack stack = new MessageStack();
    
    if(!(stack.isEmpty())) {
      test = false; //making sure the stack is empty 
    }
    
    stack.push(msg1);
    if(!(stack.isEmpty()) && stack.size() == 1) {
      if(!(stack.peek().equals(msg1))){
        test = false;
      }
    }
    
    stack.push(msg2);
    if(!(stack.isEmpty()) && stack.size() == 2) {
      if(!(stack.peek().equals(msg2))) {
        test = false;
      }
    }
      
    return test;
  }

  /**
   * Checks for the correctness of MessageStack.pop()
   * It calls MessageStack.push() and MessageStack.peek() methods.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testStackPop() {
    boolean test = true;
    
    MessageStack stack = new MessageStack();
    
    try {
      stack.pop();
      test = false; //should never reach as .pop() expected to throw exception
    }
    catch(EmptyStackException e) {
      
    }
    Message msg = new Message("Greetings", "Hello");
    stack.push(msg);
    
    if(stack.size() != 1) {
      test = false;
    }
    Message popValue = (Message) stack.pop();
    
    if(!(popValue.equals(msg))) {
      test = false;
    }
    if(stack.size() != 0) { //checking if size = 0 after popping
      test = false;
    }
    Message msg1 = new Message("Remarks", "Goodbye!");
    stack.push(msg1);
    Message msg2 = new Message("Marks", "What score did you get?");
    stack.push(msg2);
    Message msg3 = new Message("Class", "Do we have class today?");
    stack.push(msg3); //added three new messages to the stack
    if(stack.size() != 3) {
      test = false;
    }
    Message popValue1 = (Message) stack.pop();
    if(!(popValue1.equals(msg3))) {
      test =  false;
    }
    if(stack.size() != 2) {
      test = false;
    }
    Message popValue2 = (Message) stack.pop();
    if(!(popValue2.equals(msg2))) {
      test =  false;
    }
    if(stack.size() != 1) {
      test = false;
    }
    Message popValue3 = (Message) stack.pop();
    if(!(popValue3.equals(msg1))) {
      test =  false;
    }
    if(stack.size() != 0) {
      test = false;
    }
    
    return test;
    
  }
  
  /**
   * Checks for the correctness of MessageStackIterator.hasNext() and MessageStackIterator.next()
   * methods
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testMessageStackIterator() {
    boolean test = true;
    
    Message msg1 = new Message("Homework","Have you completed the homework?");
    Message msg2 = new Message("Tennis","Are you free to play today?");
    
    LinkedNode<Message> last = new LinkedNode<>(msg2);
    LinkedNode<Message> first = new LinkedNode<>(msg1, last);
    MessageStackIterator iterator = new MessageStackIterator(first);
    
    if(!(iterator.hasNext() == true && iterator.next().equals(first.getData()) && iterator.next().equals(last.getData()))) {
      test = false;
    }
    try {
      iterator.next();
      test = false; //should never be reached as .next() should throw the exception
    }
    catch (NoSuchElementException e) {
    }
    return test;
  }
  /**
   * Checks if all methods function properly
   * 
   * @return true when this the all tests work properly else false
   */
  
  public static boolean runInboxReaderTestSuite() { 
    if (testStackConstructorIsEmptyPushPeek() && testStackPop() && testMessageStackIterator()) {
      return true;
    }
    else {
      return false;
    }
  }
}