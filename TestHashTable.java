// --== CS400 File Header Information ==--
// Name: Vedant Grover
// Email: vgrover2@wisc.edu
// Team: Red Team
// Group: <your groups name: two letters>
// TA: Sid Mohan
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.util.NoSuchElementException;

/*
 * This class has methods to test the HashTableMap class
 * 
 * @author Vedant Grover
 *
 */
public class TestHashTable{
  
  /**
   * main method to call all tests
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(test1());
    System.out.println(test2());
    System.out.println(test3());
    System.out.println(test4());
    System.out.println(test5());
  }


  /**
   * tests the functionality of the put method
   * 
   * @return true if test passes
   * @return false if test fails
   */
  public static boolean test1() {

    HashTableMap testa = new HashTableMap(6);
    testa.put(0, 14);
    testa.put(1, "apple");
    testa.put(2, "87");

    if (!testa.get(0).equals(14) || !testa.get(1).equals("apple") || !testa.get(2).equals("87")) {
      System.out.println("Test failed");
      return false;
    } 
    
     if (testa.size() != 3) {
      System.out.println("Test failed");
      return false;
    }


    HashTableMap testb = new HashTableMap(4);
    testb.put(0, "apple");
    testb.put(1, "14");
    testb.put(2, 11);
    testb.put(3, 56);
    testb.put(4, 'a');
    testb.put(5, "6.4");


    if (!testb.get(0).equals("apple") || !testb.get(1).equals("14") || !testb.get(2).equals(11)
        || !testb.get(3).equals(56) || !testb.get(4).equals('a') || !testb.get(5).equals("6.4")) {
      System.out.println("Test failed");
      return false;
    } 
    if (testb.size() != 6) {
      System.out.println("Test failed");
      return false;
    } 

    if (testb.put(4, 8)) { 
      System.out.println("Test failed");
      return false;
    }

    return true;
  }

  /**
   * tests the functionality of the get method
   * 
   * @return true if test passes
   * @return false if test fails
   */
  public static boolean test2() {
    
      HashTableMap test = new HashTableMap(4);
      test.put(0, "apple");
      test.put(1, "14");
      test.put(2, 11);
      test.put(3, 56);
      test.put(4, 'a');
      test.put(5, "6.4");

      if (!test.get(0).equals("apple") || !test.get(1).equals("14") || !test.get(2).equals(11)
          || !test.get(3).equals(56) || !test.get(4).equals('a') || !test.get(5).equals("6.4")) {
        System.out.println("Test failed");
        return false;
      } 
       if (test.size() != 6) {
        System.out.println("Test failed");
        return false;
      }
    return true;
  }

  /**
   * tests the functionality of the containsKey method
   * 
   * @return true if test passes
   * @return false if test fails
   */
  public static boolean test3() {
    
      HashTableMap testa = new HashTableMap(11);
      testa.put(0, "apple");
      testa.put(1, "14");
      testa.put(2, 11);
      testa.put(3, 56);
      testa.put(4, 'a');
      testa.put(5, "6.4");

      if (!testa.containsKey(0) || !testa.containsKey(1) || !testa.containsKey(2)
          || !testa.containsKey(3) || !testa.containsKey(4) || !testa.containsKey(5)) {
        System.out.println("Test failed");
        return false;
      }
    
    
      HashTableMap testb = new HashTableMap(11);
      testb.put(0, "apple");
      testb.put(1, "14");
      testb.put(2, 11);
      testb.put(3, 56);
      testb.put(4, 'a');
      testb.put(5, "6.4");

      if (testb.containsKey(999) || testb.containsKey(999) || testb.containsKey(-9)
          || testb.containsKey(999999)) {
        System.out.println("Test failed");
        return false;
      }
    return true;
  }

  /**
   * tests the functionality of the remove method
   * 
   * @return true if test passes
   * @return false if test fails
   */
  public static boolean test4() {
    
      HashTableMap test = new HashTableMap(11);
      test.put(0, "apple");
      test.put(1, "14");
      test.put(2, 11);
      test.put(3, 56);
      test.put(4, 'a');
      test.put(5, "6.4");

      test.remove(5);
      test.remove(0);
      test.remove(3);

     
      try {
        test.get(0);
        return false;
      } catch (NoSuchElementException e1) {
      
      }

      try {
        test.get(5);
        return false;
      } catch (NoSuchElementException e2) {
       
      }
      
      try {
        test.get(3);
        return false;
      } catch (NoSuchElementException e2) {
       
      }

      if (!test.get(1).equals("14") || !test.get(2).equals(11) || !test.get(4).equals('a')) {
        System.out.println("Test failed");
        return false;
      } 

      if (test.size() != 3) {
        System.out.println("Test failed");
        return false;
      }
    
    return true;
  }
/**
 * tests the functionality of the clear method
 * 
 * @return true if test passes
 * @return false if test fails
 */
  public static boolean test5() {
    
      HashTableMap test = new HashTableMap(6);
      test.put(0, "apple");
      test.put(1, "14");
      test.put(2, 11);
      test.put(3, 56);
      test.put(4, 'a');
      test.put(5, "6.4");

      test.clear();

      try {
        test.get(4);
        return false;
      } catch (NoSuchElementException e) {
      }

      try {
        test.get(3);
        return false;
      } catch (NoSuchElementException e) {
      }

      try {
        test.get(1);
        return false;
      } catch (NoSuchElementException e) {
      }

      try {
        test.get(0);
        return false;
      } catch (NoSuchElementException e) {
      }

      if (test.size() != 0) {
        System.out.println("Test failed");
        return false;
      }
    
    return true;
  }

  

}
