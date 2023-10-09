// --== CS400 File Header Information ==--
// Name: Vedant Grover
// Email: vgrover2@wisc.edu
// Team: Red Team
// Group: ID
// TA: Sid Mohan
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

//import org.junit.Test;
//import static org.junit.Assert.*;
/**
 * This class has methods to test the RedBlackTree class
 */
public class TestRedBlackTree {
  
  /**
   * This test tests the functionality of the insert method
   */
  @Test
  public void testInsert() {
    RedBlackTree<Integer> test1 = new RedBlackTree<Integer>();
    
    try {
      test1.insert(64);
      test1.insert(44);
      test1.insert(69);
    }
    catch (Exception e) {
    }
    String toTest = test1.toString();
    assertEquals(toTest, "[64, 44, 69]");
    
  }
  
  /**
   * This test checks whether the color of nodes from the enforceRBTree method are correct
   */
  @Test
  public void enforceRBTreePropertiesTestColor() {
    RedBlackTree<Integer> test2 = new RedBlackTree<>();
    test2.insert(12);
    test2.insert(3);
    test2.insert(21);
    
    assert(!test2.root.leftChild.isBlack);
    assert(!test2.root.rightChild.isBlack);
    test2.insert(9);
    
    assert(test2.root.rightChild.isBlack);
    assert(test2.root.leftChild.isBlack);
    assert(!test2.root.leftChild.rightChild.isBlack);
    
    test2.insert(39);
    test2.insert(34);
    test2.insert(37);
    
    assert(!test2.root.rightChild.isBlack);
    
  }
  /**
   * This test checks whether the value of nodes from the enforceRBTree method are correct
   */
  @Test
  public void enforceRBTreePropertiesTestValues() {
    RedBlackTree<Integer> test3 = new RedBlackTree<>();
    test3.insert(17);
    test3.insert(2);
    test3.insert(23);
    
    test3.insert(7);
        
    test3.insert(41);
    test3.insert(37);
    test3.insert(40);
    
    assert(test3.toString().equals("[ 2, 7, 17, 23, 37, 40, 41 ]"));
    
  }
  /**
   * This test checks the colors and values of the node for complicated cases
   * 
   */
  @Test
  public void testColorandValues() {
    RedBlackTree<Integer> test4 = new RedBlackTree<Integer>();
    
    test4.insert(64);
    test4.insert(39);
    test4.insert(77);
    test4.insert(20);
    
    assert(!(test4.root.leftChild.leftChild.isBlack || !test4.root.rightChild.isBlack
        || !test4.root.leftChild.isBlack || !test4.root.isBlack));
    
    test4.insert(72);
    
    assert(!(test4.root.rightChild.leftChild.isBlack || test4.root.leftChild.leftChild.isBlack
        || !test4.root.rightChild.isBlack || !test4.root.leftChild.isBlack || !test4.root.isBlack));
    
    test4.insert(98);
    
    assert(!(test4.root.rightChild.rightChild.isBlack || test4.root.rightChild.leftChild.isBlack
        || test4.root.leftChild.leftChild.isBlack || !test4.root.rightChild.isBlack
        || !test4.root.leftChild.isBlack || !test4.root.isBlack));

  }
 

}
